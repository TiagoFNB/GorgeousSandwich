using GraphQL.Types;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL.Types
{
    public class OrderInputType : InputObjectGraphType
    {
        public OrderInputType()
        {
            Name = "orderInput";
            Field<NonNullGraphType<StringGraphType>>("userId");
            Field<ListGraphType<OrderDeliveryInputType>>("orderDeliveries");

        }
    }

    public class OrderDeliveryInputType : InputObjectGraphType
    {
        public OrderDeliveryInputType()
        {
            Name = "orderDeliveryInput";
            Field<NonNullGraphType<StringGraphType>>("shopId");
            Field<NonNullGraphType<StringGraphType>>("deliveryDate");
            Field<ListGraphType<OrderSandwichInputType>>("items");

        }
    }

    public class OrderSandwichInputType : InputObjectGraphType
    {
        public OrderSandwichInputType()
        {
            Name = "orderSandwichInput";
            Field<NonNullGraphType<StringGraphType>>("sandwichId");
            Field<NonNullGraphType<IntGraphType>>("quantity");

        }
    }
}
