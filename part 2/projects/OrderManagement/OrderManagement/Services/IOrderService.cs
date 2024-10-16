using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Orders;
using OrderManagement.DTO;

namespace OrderManagement.Services
{
    public interface IOrderService
    {
        public Task<Order> AddAsync(OrderDTO dto);
        public Task<List<Order>> GetAll();
        public Task<List<Order>> GenerateMonthlyReport();
        public Task<List<Delivery>> GetAllByShopId(string shopId);
        public Task<List<Delivery>> GetAllDelivery();
        public Task<Delivery> ChangeDelivery(string deliveryId);
    }

}