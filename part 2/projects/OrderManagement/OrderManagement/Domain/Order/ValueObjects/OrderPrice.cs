using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using DDDNetCore.Domain.Shared;

namespace OrderManagement.Domain.Orders.ValueObjects
{
    public class OrderPrice : ValueObject
    {

        
        public decimal Price { get; set; }

        public OrderPrice(decimal price)
        {
            Validate(price);
            Price = price;
        }
        private OrderPrice() { }


        private void Validate(decimal price)
        {

            if (String.IsNullOrEmpty(price.ToString()))
            {
                throw new Exception("Price must be defined");
            }
            if (price<0)
            {
                throw new Exception("Price must not be negative");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return Price;
        }
    }
}
