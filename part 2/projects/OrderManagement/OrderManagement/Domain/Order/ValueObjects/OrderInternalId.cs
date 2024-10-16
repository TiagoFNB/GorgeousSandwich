using DDDNetCore.Domain.Shared;
using OrderManagement.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace OrderManagement.Domain.Orders.ValueObjects
{
    public class OrderInternalId : EntityId
    {

        public string id { get; set; }

        public OrderInternalId(string ids) : base(ids)
        {
            Validate(ids);
            id = ids;
        }

        public static OrderInternalId genNewId()
        {
            return new OrderInternalId(Guid.NewGuid().ToString());
        }


        private void Validate(string ids)
        {

            if (string.IsNullOrEmpty(ids))
            {
                throw new Exception("OrderInternalId must be defined");
            }
            if (ids.Length == 0)
            {
                throw new Exception("OrderInternalId must not be negative");
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
