namespace Eksamensopgave2016.Exceptions
{
    class InsufficientCreditsException : ExceptionMaster
    {
        public InsufficientCreditsException(User _user, Product _product)
            : base($"You do not posses enough cash to process this payment. Price of {_product.productName} is {_product.productPriceTag} and your balance is {_user.Balance}")
        {

        }
    }
}
