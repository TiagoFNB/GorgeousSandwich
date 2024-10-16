using DDDNetCore.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class DeliveryDay : ValueObject
    {

        public DateTime deliveryDate { get; set; }

        public DeliveryDay(string date)
        {
            Validate(date);
            deliveryDate = DateTime.Parse(date); 
        }
        private DeliveryDay() { }


        private void Validate(string date)
        {
            DateTime dateResult;
            if (!DateTime.TryParse(date,out dateResult))
            {
                throw new Exception("DeliveryDay is invalide");
            }
           
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return deliveryDate;
        }
    }
}
