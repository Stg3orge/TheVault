using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NotSoCoolShop.Domain
{
    public class Order
    {
        public Order()
        {
            orderLines = new List<OrderLine>();
        }

        public int Id { get; set; }
        public decimal totalPrice { get; set; }
        public List<OrderLine> orderLines { get; set; }
        public Customer customer { get; set; }
    }
}
