using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NotSoCoolShop.Domain
{
    public class Customer
    {
        public int Id { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public List<Order> orders { get; set; }
    }
}
