using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using OrderManagement.Infrastructure.Shared;
using Microsoft.EntityFrameworkCore;
using OrderManagement.Domain.Orders.ValueObjects;
using OrderManagement.Domain.Orders;

namespace OrderManagement.Infrastructure
{
    public class OrderRepository : BaseRepository<Order, OrderInternalId>, IOrderRepository
    {
        private readonly DbSet<Order> _objs;
        public OrderRepository(OrderDbContext context) : base(context.Orders)
        {
            this._objs = context.Orders;
        }

        public async Task<List<Order>> GetAllByMonthAsync(DateTime startDate, DateTime endDate)
        {
            
            var list = await this._objs.FromSqlInterpolated($"SELECT o.* FROM dbo.Orders o INNER JOIN dbo.Deliveries d ON d.OrderId=o.Id WHERE DeliveryDate BETWEEN {startDate} AND {endDate}").ToListAsync();
            return list;
        }
    }
}
