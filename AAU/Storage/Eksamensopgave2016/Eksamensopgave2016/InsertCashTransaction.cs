/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;

namespace Eksamensopgave2016.Exceptions
{
    public class InsertCashTransaction : Transaction
    {
        public InsertCashTransaction(User _user, DateTime _date, decimal insertamount) : base(_user, insertamount)
        {
            amountTransaction = insertamount;
        }

        public decimal executeInsertMethod(User _user)
        {
            if (amountTransaction <= 0)
            {
                throw new ArgumentException("Cannot insert cash less than or equal to zero");
            }
            else
            {
                return _user.Balance += amountTransaction;
            }
        }

        public void activeSelect(User _user, Product _product)
        {
            if (_product.Active == false)
            {
                throw new NonActiveProductException(_user, _product);
            }
        }

        public override string ToString()
        {
            return string.Format($"Inserted Money to Users Balance. ID of transaction: {transactionCountID} Username: {userTransaction} Date: {Date}");
        }
    }
}
