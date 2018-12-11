using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NotSoCoolShop.Domain
{
    public class Product
    {
        public int Id { get; set; }
        public string title { get; set; }
        public List<OrderLine> orderLines { get; set; }
        public decimal price { get; set; }
    }
}
