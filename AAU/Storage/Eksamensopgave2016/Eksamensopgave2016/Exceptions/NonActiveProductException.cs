namespace Eksamensopgave2016.Exceptions
{
    class NonActiveProductException : ExceptionMaster
    {
        public NonActiveProductException(User _user, Product _product)
            : base($"{_user.userName} can not buy {_product.productName} because it is not active")
        {

        }
    }
}
