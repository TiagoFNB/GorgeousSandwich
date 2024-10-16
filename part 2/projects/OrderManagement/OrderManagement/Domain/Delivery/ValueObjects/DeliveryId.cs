using DDDNetCore.Domain.Shared;
using OrderManagement.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class DeliveryId : EntityId
    {

        public string id { get; set; }

        public DeliveryId(string ids) : base(ids)
        {
            Validate(ids);
            id = ids;
        }
       

        public static DeliveryId genNewId()
        {
            return new DeliveryId(Guid.NewGuid().ToString());
        }

        private void Validate(string ids)
        {

            if (string.IsNullOrEmpty(ids))
            {
                throw new Exception("DeliveryId must be defined");
            }
            if (ids.Length == 0)
            {
                throw new Exception("DeliveryId must not be negative");
            }
        }


     

        protected override object createFromString(string text)
        {
            return text;
        }

        public override string AsString()
        {
            return (string)base.Value;
        }
    }
}

