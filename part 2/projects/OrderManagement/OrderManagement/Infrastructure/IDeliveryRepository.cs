using System;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Deliveries.ValueObjects;
using OrderManagement.Domain.Shared;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace OrderManagement.Infrastructure
{
    public interface IDeliveryRepository : IRepository<Delivery, DeliveryId>
    {
        Task<List<Delivery>> GetCurrentDeliveries(string shopId, string deliveryPeriodDate, string deliveryPeriodEndDate);
        Task<List<Delivery>> GetAllByShopId(string shopId);
        Task<Delivery> Update(Delivery delivery);
    }
}