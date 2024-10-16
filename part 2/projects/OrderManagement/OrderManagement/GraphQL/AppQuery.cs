using GraphQL.Types;
using OrderManagement.GraphQL.Types;
using OrderManagement.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GraphQL;

namespace OrderManagement.GraphQL
{
    public class AppQuery : ObjectGraphType
    {
        public AppQuery(IOrderService os)
        {
            Field<ListGraphType<OrderType>>(
               "orders",
               resolve: context => os.GetAll()
           );

            Field<ListGraphType<OrderType>>(
                "generateMonthlyReport",
                resolve: context => os.GenerateMonthlyReport()
            );
            
            Field<ListGraphType<DeliveryType>>(
                "listByShopId",
                arguments: new QueryArguments(new QueryArgument<NonNullGraphType<StringGraphType>> { Name = "shopId" }),
                resolve: context =>
                {
                    var shopId = context.GetArgument<string>("shopId");
                    return os.GetAllByShopId(shopId);
                }
            );
            
            Field<ListGraphType<DeliveryType>>(
                "deliveries",
                resolve: context => os.GetAllDelivery()
            );
        }
    }
}