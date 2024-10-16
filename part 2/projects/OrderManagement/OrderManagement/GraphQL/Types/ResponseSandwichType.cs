using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class ResponseSandwichType
    {

        public GetSandwichById getSandwichById { get; set; }
   
    }
    public class GetSandwichById
    {

        public ResponseSandwichIdType id { get; set; }
        public ResponseSandwichPriceType price { get; set; }
    }
    public class ResponseSandwichIdType
    {
        public string id { get; set; }
    }
    public class ResponseSandwichPriceType
    {
        public decimal price { get; set; }
    }
}
