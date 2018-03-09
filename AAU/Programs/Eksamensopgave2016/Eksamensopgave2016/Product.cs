/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

namespace Eksamensopgave2016
{
    public class Product
    {
        public decimal productPriceTag;
        private bool active;
        public bool Active
        {
            get
            {
                return this.active;
            }
            set
            {
                this.active = value;
            }
        }

        private bool CanBeBoughtOnCredit; // Not Implemented
        public bool canBeBoughtOnCredit { get; private set; }

        public Product(int _productid, string _productname, decimal _productpricetag, bool _active)
        {
            productID = _productid;
            productName = _productname;
            productPriceTag = _productpricetag;
            active = _active;
        }

        // generally using private setters to ensure at least somewhat privacy
        private int productid;
        public int productID
        {
            get
            {
                return productid;
            }
            private set
            {
                productid = value;
                if (value <= 0)
                {
                    throw new System.Exception($"ERRORCODE 200: Product ID cannot be 0 or less.");
                }
            }
        }

        private string productname;
        public string productName
        {
            get
            {
                return productname;
            }
            private set
            {
                productname = value;
                if (value == null)
                {
                    throw new System.Exception($"ERRORCODE 201: Products name cannot be of null value");
                }
            }
        }


        public override string ToString()
        {
            return "ID: " + productID + "Name: " + productName + "Price: " + productPriceTag + active;
        }
    }
}
