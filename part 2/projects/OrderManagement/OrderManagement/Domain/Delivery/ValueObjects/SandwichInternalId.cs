using DDDNetCore.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Deliveries.ValueObjects
{
    public class SandwichInternalId : ValueObject
    {

        public string id { get; set; }

        public SandwichInternalId(string ids)
        {
            Validate(ids);
            id = ids;
        }
        private SandwichInternalId() { }


        private void Validate(string ids)
        {

            if (string.IsNullOrEmpty(ids))
            {
                throw new Exception("SandwichInternalId must be defined");
            }
            if (ids.Length == 0)
            {
                throw new Exception("SandwichInternalId must not be negative");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return id;
        }
    }
}
