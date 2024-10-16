using DDDNetCore.Domain.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.Domain.Orders.ValueObjects
{
    public class UserInternalId : ValueObject
    {

        public string userId { get; set; }

        public UserInternalId(string ids)
        {
            Validate(ids);
            userId = ids;
        }
        private UserInternalId() { }


        private void Validate(string ids)
        {

            if (string.IsNullOrEmpty(ids))
            {
                throw new Exception("UserInternalId must be defined");
            }
            if (ids.Length == 0)
            {
                throw new Exception("UserInternalId length must not be negative");
            }
        }


        protected override IEnumerable<object> GetEqualityComponents()
        {
            yield return userId;
        }
    }
}
