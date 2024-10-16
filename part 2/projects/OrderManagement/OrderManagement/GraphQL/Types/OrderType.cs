using GraphQL.Types;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Orders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class OrderType : ObjectGraphType<Order>
    {
        public OrderType()
        {
            Name = "Order";
            Field(_ => _.Id.id).Description("Order's Id.");
            Field(_ => _.price.Price).Description
            ("price of the Order");
            Field((_ => _.userId.userId)).Name("userId").Description
            ("User id of the Order");
            //Field<ListGraphType<Delivery>>("orderDeliveries").Description
            //("Deliveries of the Order");

        }
    }
}
