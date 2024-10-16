using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using OrderManagement.Infrastructure;
using OrderManagement.Infrastructure.Shared;
using Microsoft.EntityFrameworkCore;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Deliveries.ValueObjects;
using Microsoft.Data.SqlClient;

namespace OrderManagement.Infrastructure
{
    public class DeliveryRepository : BaseRepository<Delivery, DeliveryId>, IDeliveryRepository
    {
        private readonly DbSet<Delivery> _objs;
        public DeliveryRepository(OrderDbContext context) : base(context.Deliveries)
        {
            this._objs = context.Deliveries;
        }

        public async Task<List<Delivery>> GetCurrentDeliveries(string shopId, string deliveryPeriodDate, string deliveryPeriodEndDate)
        {

            DateTime dateFrom;
            bool isValidDateFrom = DateTime.TryParse(deliveryPeriodDate, out dateFrom);

            DateTime dateTo;
            bool isValidDateTo = DateTime.TryParse(deliveryPeriodEndDate, out dateTo);
           
            if (!(isValidDateFrom && isValidDateTo))
            {
                // Handle for parsed fromDate & toDate is not a valid date
                return new List<Delivery>();
            }
            var a = DeliveryStatus.Pending;

            
            var list = await this._objs.FromSqlInterpolated($"SELECT * FROM dbo.Deliveries WHERE ShopId = {shopId} AND DeliveryDate BETWEEN {dateFrom} AND {dateTo}").ToListAsync();
            //.ToListAsync()
            return list;
        }

        public async Task<List<Delivery>> GetAllByShopId(string shopId)
        {

            var list = await this._objs
                .FromSqlInterpolated(
                    $"SELECT * FROM dbo.Deliveries WHERE ShopId LIKE {shopId}")
                .ToListAsync();
            return list;
        }
        
        public async Task<Delivery> Update(Delivery delivery)
        {
            _objs.Update(delivery);
            return delivery;
        } 
    }
}
