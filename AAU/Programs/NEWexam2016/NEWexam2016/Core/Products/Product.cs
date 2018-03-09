/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NEWexam2016.Core
{
    public class Product
    {
        public Product(int ID, string name, decimal price, bool active, bool canBeBoughtOnCredit)
        {
            Name = name;
            Price = price;
            Active = active;
            CanBeBoughtOnCredit = canBeBoughtOnCredit;
            ProductID = ID;
        }

        private int _productID;
        public int ProductID
        {
            get
            {
                return _productID;
            }
            private set
            {
                _productID = value;
            }
        }

        private string _name;
        public string Name
        {
            get
            {
                {
                    return _name;
                }
            }
            set
            {
                {
                    _name = value;
                    if (value == null)
                    {
                        throw new ArgumentException("Name can not be null");
                    }
                }
            }
        }

        private decimal _price;
        public decimal Price
        {
            get
            {
                return _price;
            }
            set
            {
                _price = value;
            }
        }

        private bool _active;
        public bool Active
        {
            get
            {
                return _active;
            }
            set
            {
                _active = value;
            }
        }

        private bool _canBeBoughtOnCredit;
        public bool CanBeBoughtOnCredit
        {
            get
            {
                return _canBeBoughtOnCredit;
            }
            set
            {
                _canBeBoughtOnCredit = value;
            }
        }

        public override string ToString()
        {
            return ($"ID: {ProductID}, Product: {Name}, Price: {Price}.");
        }
    }
}
