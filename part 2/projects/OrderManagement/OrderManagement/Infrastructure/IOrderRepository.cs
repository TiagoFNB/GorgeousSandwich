using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using OrderManagement.Domain.Orders;
using OrderManagement.Domain.Orders.ValueObjects;
using OrderManagement.Domain.Shared;

namespace OrderManagement.Infrastructure
{
    public interface IOrderRepository : IRepository<Order, OrderInternalId>
    {
        Task<List<Order>> GetAllByMonthAsync(DateTime startDate, DateTime endDate);
        
        // Task<Order> GetByIdDeliveryIdAsync(string deliveryId);
    }
}