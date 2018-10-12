using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompanyData.Model {

   public  class Product {

        private int id;
        public int Id {
            get { return id; }
            set { id = value; }
        }

        private string productName;
        public string ProductName {
            get { return productName; }
            set { productName = value; }
        }

        private decimal price;
        public decimal Price {
            get { return price; }
            set { price = value; }
        }

        // Constructors
        public Product(string productName, decimal price) {
            ProductName = productName;
            Price = price;
        }
        public Product(int id, string productName, decimal price) : this(productName, price) {
            Id = id;
        }

        public override string ToString() {
            return $"{Id}: {productName}, Price: {Price}";
        }
    }
}
