using OrderManagement.Domain.Deliveries.ValueObjects;
using OrderManagement.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries
{
    public class Delivery : Entity<DeliveryId>
    {


        public DeliveryId Id { get; private set; }
        public DeliveryDay day { get; private set; }
        public DeliveryStatus status { get; private set; }

        public ShopInternalId shopId { get; private set; }

        public virtual ICollection<OrderSandwich> items { get; private set; }

        private Delivery()
        {
        }

        public Delivery(DeliveryId id,DeliveryDay day, DeliveryStatus status, ShopInternalId shopId, ICollection<OrderSandwich> items)
        {
            //  this.Id = new RoleId(Guid.NewGuid());
            // Name = new RoleName(name);
            this.Id = id;
            this.day = day;
            this.status = status;
            this.shopId = shopId;
            this.items = items;

        }

        public Delivery(DeliveryId id, DeliveryDay day, DeliveryStatus status, ShopInternalId shopId)
        {
            //  this.Id = new RoleId(Guid.NewGuid());
            // Name = new RoleName(name);
            this.Id = id;
            this.day = day;
            this.status = status;
            this.shopId = shopId;
            this.items = new List<OrderSandwich>();


        }

        public void addSandwich(OrderSandwich s)
        {
            this.items.Add(s);
        }

        public void changeStatus()
        {
            this.status = DeliveryStatus.Completed;
        }


    }
}

