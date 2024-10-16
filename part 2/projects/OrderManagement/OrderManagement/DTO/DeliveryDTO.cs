using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.DTO
{
    public class DeliveryDTO
    {

        public string deliveryDate { get; private set; }


        public string shopId { get; private set; }

        public List<OrderSandwichDTO> items { get; private set; }
    }
}
