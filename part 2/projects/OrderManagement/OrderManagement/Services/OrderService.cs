using GraphQL;
using GraphQL.Client.Abstractions;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;
using Microsoft.Extensions.Configuration;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Deliveries.ValueObjects;
using OrderManagement.Domain.Orders;
using OrderManagement.Domain.Orders.ValueObjects;
using OrderManagement.Domain.Shared;
using OrderManagement.DTO;
using OrderManagement.GraphQL.Types;
using OrderManagement.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Services
{
    public class OrderService : IOrderService
    {
        private readonly IUnitOfWork _unitOfWork;

        private readonly IOrderRepository _orderRepository;
        private readonly IDeliveryRepository _deliveryRepository;
        private readonly IConfiguration _configuration;

        private IGraphQLClient _sandwiches;
        private IGraphQLClient _users;
        private IGraphQLClient _shops;
        private IGraphQLClient _promotions;

        public OrderService(
            IDeliveryRepository deliveryRepository,
            IOrderRepository orderRepository,
            IUnitOfWork unitOfWork,
            IConfiguration configuration)
        {
            _deliveryRepository = deliveryRepository;
            _orderRepository = orderRepository;
            _unitOfWork = unitOfWork;
            _configuration = configuration;
            _sandwiches = new GraphQLHttpClient(_configuration["SandwichesURI"], new NewtonsoftJsonSerializer());
            _users = new GraphQLHttpClient(_configuration["UsersURI"], new NewtonsoftJsonSerializer());
            _shops = new GraphQLHttpClient(_configuration["ShopsURI"], new NewtonsoftJsonSerializer());
            _promotions = new GraphQLHttpClient(_configuration["PromotionsURI"], new NewtonsoftJsonSerializer());
        }
        public async Task<List<Order>> GetAll()
        {
            return await _orderRepository.GetAllAsync();
        }
        public async Task<Order> AddAsync( OrderDTO dto)
        {

            //validar USer
            //enquanto nao dou pull para ter o ms de user
           await validateUserAsync(dto.userId);



            OrderInternalId id = OrderInternalId.genNewId();
            OrderPrice p = new OrderPrice(0);
            UserInternalId userId = new UserInternalId(dto.userId);
            Order o = new Order(id, p, userId);
            decimal price = 0;
            foreach (DeliveryDTO del in dto.orderDeliveries)
            {
                //validar SHOP AQUI
                ResponseShopType shop = await validateShopAsync(del.shopId);

                DeliveryId deliveryId = DeliveryId.genNewId();
                DeliveryDay date = new DeliveryDay(del.deliveryDate);
                List<Delivery> currentDel = await _deliveryRepository.GetCurrentDeliveries(del.shopId, del.deliveryDate, date.deliveryDate.AddMinutes(
                    Convert.ToDouble(shop.getShopById.shopProperties.period.period)).ToString());
                ShopInternalId shopId = new ShopInternalId(del.shopId);
                TimeSpan ts = DateTime.Now - date.deliveryDate;
                bool isValidMinAcceptable = ts.TotalMinutes < Convert.ToDouble(shop.getShopById.shopProperties.minimumAcceptableAdvance.minimumAcceptableAdvance);

                if (isValidMinAcceptable)
                {
                    throw new InvalidOperationException("Delivery date is too soon!");
                }
                if (currentDel.Count >= Convert.ToInt32(shop.getShopById.shopProperties.maximumNumberDeliveries.maximumNumberDeliveries))
                {
                    throw new InvalidOperationException("Shop is full for the specified deliveryd date!");
                }
                Delivery d = new Delivery(deliveryId, date, DeliveryStatus.Pending, shopId);
                foreach (OrderSandwichDTO s in del.items)
                {
                    //validar sandwich
                    
                    ResponseSandwichType sand = await validateSandwichAsync(s.sandwichId);
                    SandwichInternalId sId = new SandwichInternalId(s.sandwichId);
                    OrderSandwichQuantity qt = new OrderSandwichQuantity(s.quantity);
                    var sandPrice = sand.getSandwichById.price.price * s.quantity;
                    //APLICAR PROMOCAO LOGICA
                    ResponsePromotionsType promotions = await getPromotionsAsync(s.sandwichId, del.deliveryDate);
                    if(promotions.findBySandwichAndPeriod == null)
                    {
                        price = price + sandPrice;
                    }
                    else
                    {
                        var discount = 0m;
                        switch (_configuration["PromotionPossibility"])
                        {
                            case "Cumulatively":

                                foreach(ResponsePromotionType promo in promotions.findBySandwichAndPeriod)
                                {
                                    discount = discount + Convert.ToDecimal(promo.percentage.percentage);
                                }
                                break;
                            case "MostFavourable":
                                var biggestPerc = 0m;
                                foreach (ResponsePromotionType promo in promotions.findBySandwichAndPeriod)
                                {
                                    if(Convert.ToDecimal(promo.percentage.percentage) > biggestPerc)
                                    {
                                        biggestPerc = Convert.ToDecimal(promo.percentage.percentage);
                                    }
                                }
                                discount = biggestPerc;
                                break;
                        }
                        price = sandPrice * (discount / 100);
                    }
                    
                    OrderSandwich os = new OrderSandwich(sId, qt);
                    d.addSandwich(os);
                }
                o.addDelivery(d);
            }
            o.price.Price = price;


            await this._orderRepository.AddAsync(o);

            await this._unitOfWork.CommitAsync();



            return o;



        }

        private async Task<ResponseSandwichType> validateSandwichAsync(string id)
        {
            
            var query = new GraphQLRequest
            {
                Query = @"
                query($sid : String) {
getSandwichById(id : $sid)
{
                      id{id}
                      price{price}
                    }
                }"
                ,
                Variables = new { sid = id }
            };


            var response = await _sandwiches.SendQueryAsync<ResponseSandwichType>(query);
            if(response.Data.getSandwichById == null)
            {
                throw new ExecutionError("Sandwich does not exist!");
            }
            return response.Data;
        }

        private async Task<ResponseUserType> validateUserAsync(string id)
        {

            var query = new GraphQLRequest
            {
                Query = @"
                query($sid : String) {
getCustomerById(id : $sid)
{
                      id{id}
                    }
                }"
                ,
                Variables = new { sid = id }
            };


            var response = await _users.SendQueryAsync<ResponseUserType>(query);
            if (response.Data.getCustomerById == null)
            {
                throw new ExecutionError("User does not exist!");
            }
            return response.Data;
        }

        private async Task<ResponseShopType> validateShopAsync(string id)
        {

            var query = new GraphQLRequest
            {
                Query = @"
                query($sid : String) {
getShopById(id : $sid)
{
                      id{id}
                      shopProperties{
                        maximumNumberDeliveries {maximumNumberDeliveries}
                        minimumAcceptableAdvance {minimumAcceptableAdvance}
                        period {period}

                      }
                      dailySchedules{
                        openingHours {openingHours}
                        closingHours {closingHours}
                        day 

                        }
                    }
                }"
                ,
                Variables = new { sid = id }
            };


            var response = await _shops.SendQueryAsync<ResponseShopType>(query);
            if (response.Data.getShopById == null)
            {
                throw new ExecutionError("Shop does not exist!");
            }
            return response.Data;
        }

        private async Task<ResponsePromotionsType> getPromotionsAsync(string sid, string date)
        {
 
            var query = new GraphQLRequest
            {
                Query = @"
                query($sandwichInternalId : String, $date: String) {
                findBySandwichAndPeriod(sandwichInternalId : $sandwichInternalId, date: $date)
                {

                        id {id}
                        type
                        percentage {percentage}
                        sandwichId {sandwichId}
                        period {
                            promotionPeriodBeginning{promotionPeriodBeginning},
                            promotionPeriodEnd{promotionPeriodEnd}}
                    }
                }"
                ,
                Variables = new { sandwichInternalId = sid, date = date }
            };


            var response = await _promotions.SendQueryAsync<ResponsePromotionsType>(query);

            return response.Data;
        }

        public async Task<List<Order>> GenerateMonthlyReport()
        {
            var startDate = DateTime.Now.Date;
            startDate = new DateTime(startDate.Year, startDate.Month, 1);
            
            var endDate = startDate.AddMonths(1);

            return await _orderRepository.GetAllByMonthAsync(startDate, endDate);
        }

        public async Task<List<Delivery>> GetAllByShopId(string shopId)
        {
            return await _deliveryRepository.GetAllByShopId(shopId);
        }
        
        public async Task<List<Delivery>> GetAllDelivery()
        {
            return await _deliveryRepository.GetAllAsync();
        }
        
        public async Task<Delivery> ChangeDelivery(string deliveryId)
        {
            Delivery delivery = await _deliveryRepository.GetByIdAsync(new DeliveryId(deliveryId));
            
            delivery.changeStatus();
            
            Delivery final = await _deliveryRepository.Update(delivery);
            
            // Delivery delivery = await _deliveryRepository.GetByIdAsync(new DeliveryId(deliveryId));
            //
            // delivery.changeStatus();
            //
            // Delivery result = await _deliveryRepository.AddAsync(delivery);
            
            await this._unitOfWork.CommitAsync();

            return final;
        }
    }
}
