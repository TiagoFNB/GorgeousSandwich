using OrderManagement.Domain.Orders.ValueObjects;
using OrderManagement.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using OrderManagement.Domain.Deliveries;

namespace OrderManagement.Domain.Orders
{
    public class Order : Entity<OrderInternalId>, IAggregateRoot
    {
 

        public OrderInternalId Id { get; private set; }
        public OrderPrice price { get; private set; }
        public UserInternalId userId { get; private set; }

        public ICollection<Delivery> orderDeliveries { get; private set; }

        private Order()
        {
        }

        public Order(OrderInternalId id, OrderPrice price, UserInternalId userId , ICollection<Delivery> orderDeliveries)
        {
            //  this.Id = new RoleId(Guid.NewGuid());
            // Name = new RoleName(name);
            this.Id = id;
            this.price = price;
            this.orderDeliveries = orderDeliveries;
            this.userId = userId;

        }

        public Order(OrderInternalId id, OrderPrice price, UserInternalId userId)
        {
            //  this.Id = new RoleId(Guid.NewGuid());
            // Name = new RoleName(name);
            this.Id = id;
            this.price = price;
            this.orderDeliveries = new List<Delivery>();
            this.userId = userId;

        }

        public void addDelivery(Delivery s)
        {
            this.orderDeliveries.Add(s);
        }


    }
}
