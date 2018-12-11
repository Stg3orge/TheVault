using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NotSoCoolShop.Domain
{
    public class OrderLine
    {
        public int Id { get; set; }
        public Product product { get; set; }
        public Order order { get; set; }
        public int amount { get; set; }
    }
}
