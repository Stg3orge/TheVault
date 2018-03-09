/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;

namespace Eksamensopgave2016
{
    public class Transaction
    {
        public Transaction(User _user, decimal amount) // Constructor for user, getting current time and date
        {
            this.usertransaction = _user;
            this.Date = DateTime.Now;
            amountTransaction = amount;
            this.transactionCountID = Transaction.transactionIDCounter;
            Transaction.transactionIDCounter++; // Same ID management for users
        }

        static private int transactionIDCounter = 100;
        private int transactionid = 1;
        public int transactionCountID
        {
            get { return transactionid; }
            private set
            {
                transactionid = transactionIDCounter;
            }
        }

        private User usertransaction;
        public User userTransaction { get { return usertransaction; } set { } }

        public DateTime Date = DateTime.Now; // local

        private decimal amounttransaction;
        public decimal amountTransaction { get { return amounttransaction; } set { amounttransaction = value; } }

        // No reason to use an execute property because of BuyTransaction and InsertCashTransaction's execute methods

        public override string ToString()
        {
            return string.Format($"Transacted. ID of transaction: {transactionid} Username: {usertransaction} Date: {Date}");
        }
    }

}
