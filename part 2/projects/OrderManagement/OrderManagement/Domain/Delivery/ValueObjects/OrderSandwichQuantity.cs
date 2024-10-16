using DDDNetCore.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class OrderSandwichQuantity : ValueObject
    {

        public int Quantity { get; set; }

        public OrderSandwichQuantity(int qt)
        {
            Validate(qt);
            Quantity = qt;
        }
        private OrderSandwichQuantity() { }


        private void Validate(int qt)
        {

            if (String.IsNullOrEmpty(qt.ToString()))
            {
                throw new Exception("Quantity must be defined");
            }
            if (qt < 0)
            {
                throw new Exception("Quantity must not be negative");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return Quantity;
        }
    }
}
