using DDDNetCore.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class ShopInternalId : ValueObject
    {

        public string shopId { get; set; }

        public ShopInternalId(string shopIds)
        {
            Validate(shopIds);
            shopId = shopIds;
        }
        private ShopInternalId() { }


        private void Validate(string ids)
        {

            if (string.IsNullOrEmpty(ids))
            {
                throw new Exception("ShopInternalId must be defined");
            }
            if (ids.Length == 0)
            {
                throw new Exception("ShopInternalId must not be negative");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return shopId;
        }
    }
}
