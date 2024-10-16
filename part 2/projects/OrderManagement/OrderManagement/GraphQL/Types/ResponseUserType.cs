using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class ResponseUserType
    {

        public GetCustomerById getCustomerById { get; set; }
   
    }
    public class GetCustomerById
    {

        public ResponseUserIdType id { get; set; }
       
    }
    public class ResponseUserIdType
    {
        public string id { get; set; }
    }

}
