using GraphQL.Types;
using OrderManagement.Domain.Deliveries;
using OrderManagement.Domain.Deliveries.ValueObjects;

namespace OrderManagement.GraphQL.Types
{
    public class DeliveryType : ObjectGraphType<Delivery>
    {
        public DeliveryType()
        {
            Name = "Delivery";
            Field(_ => _.Id.id).Description("Delivery's Id.");
            Field(_ => _.shopId.shopId).Description
                ("Shop id of the delivery");
            
            Field<DeliveryStatusEnum>("status", "The status of the delivery.");
            
            Field(_ => _.day.deliveryDate).Description
                ("Delivery Date of the delivery");
            Field<ListGraphType<OrderSandwichType>>("items");
        }
    }
    
    public class OrderSandwichType : ObjectGraphType<OrderSandwich>
    {
        public OrderSandwichType()
        {
            Name = "items";
            Field(_ => _.quantity.Quantity).Description("Quantity of sandwich.");
            Field(_ => _.sandwichId.id).Description
                ("SandwichId id of the delivery");
        }
    }

    public class DeliveryStatusEnum : EnumerationGraphType<DeliveryStatus>
    {
    }
}
