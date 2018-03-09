/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core.Exceptions;

namespace NEWexam2016.Core
{
    public class BuyTransaction : Transaction
    {
        public BuyTransaction(User user, DateTime date, Product product) : base(user, date)
        {
            Product = product;
        }

        private Product _product;
        public Product Product
        {
            get
            {
                return _product;
            }

            set
            {
                _product = value;
            }
        }

        public override void Execute()
        {
            if (Product.Active == false)
            {
                throw new NonActiveProductException(Product);
            }
            else if (Product.CanBeBoughtOnCredit)
            {
                User.Balance -= Product.Price;
            }
            else if (User.Balance > Product.Price)
            {
                User.Balance -= Product.Price;
            }
            else if (User.Balance < Product.Price)
            {
                throw new InsufficientCreditsException(User, Product);
            }

        }

        public override string ToString()
        {
            return ($"{base.ToString()}, User purchased {Product} DKK."); // base.ToString er Transaction.ToString() + info fra
        }
    }
}
