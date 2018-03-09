/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using Eksamensopgave2016.Exceptions;

namespace Eksamensopgave2016
{
    public class BuyTransaction : Transaction
    {
        public BuyTransaction(User _user, decimal _price, Product producttobuy) : base(_user, _price)
        {
            productItem = producttobuy;
            userTransaction = _user;
        }

        private Product productitem;
        public Product productItem
        {
            get
            {
                return productitem;
            }
            set
            {
                productitem = value;
            }
        }

        public decimal executeBuyMethod(User _user, Product _product)
        {
            if (_user.Balance < _product.productPriceTag)
            {
                throw new InsufficientCreditsException(_user, _product);
            }
            else
            {
                return _user.Balance -= amountTransaction;
            }
        }

        public void productActiveSelect(User _user)
        {
            if (productitem.Active == false)
            {
                throw new NonActiveProductException(_user, productitem);
            }
        }
    }
}
