using GraphQL;
using GraphQL.Types;
using OrderManagement.DTO;
using OrderManagement.GraphQL.Types;
using OrderManagement.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.GraphQL
{
    public class AppMutation : ObjectGraphType
    {
        public AppMutation(IOrderService service)
        {
            
          
            Field<OrderType>(
                "createOrder",
                arguments: new QueryArguments(new QueryArgument<NonNullGraphType<OrderInputType>> { Name = "order" }),
                resolve: context =>
                {
                    var order = context.GetArgument<OrderDTO>("order");

                    return service.AddAsync(order);
                }
            );
            
            Field<DeliveryType>(
                "changeDelivery",
                arguments: new QueryArguments(new QueryArgument<NonNullGraphType<StringGraphType>> { Name = "deliveryId" }),
                resolve: context =>
                {
                    var deliveryId = context.GetArgument<string>("deliveryId");
                    return service.ChangeDelivery(deliveryId);
                }
            );
        }
    }
}
