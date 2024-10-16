using DDDNetCore.Domain.Shared;
using OrderManagement.Domain.Deliveries.ValueObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class OrderSandwich : ValueObject
    {

        public SandwichInternalId sandwichId { get; set; }
        public OrderSandwichQuantity quantity { get; set; }

        public OrderSandwich(SandwichInternalId id,OrderSandwichQuantity qt)
        {
            Validate(id,qt);
            sandwichId = id;
            quantity = qt;
        }
        private OrderSandwich() { }


        private void Validate(SandwichInternalId id, OrderSandwichQuantity qt)
        {

            if (qt == null)
            {
                throw new Exception("OrderSandwichQuantity must be defined");
            }
            if (id == null)
            {
                throw new Exception("SandwichInternalId must be defined");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return quantity;
            yield return sandwichId;
        }
    }
}

