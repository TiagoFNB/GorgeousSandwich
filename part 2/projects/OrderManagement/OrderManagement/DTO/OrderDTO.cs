using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderManagement.DTO
{
    public class OrderDTO
    {
        public decimal price { get; private set; }


        public string userId { get; private set; }

        public List<DeliveryDTO> orderDeliveries { get; private set; }


    }
}
