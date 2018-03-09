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
    public abstract class Transaction
    {
        public Transaction(User user, DateTime date)
        {
            User = user;
            Date = DateTime.Now;
            this._transactionID = Transaction.Counter;
            Transaction.Counter++;
        }

        static int Counter = 100;
        private int _transactionID;
        public int TransactionID
        {
            get
            {
                return _transactionID;
            }

            set
            {
                _transactionID = value;
            }
        }

        private User _user;
        public User User
        {
            get
            {
                return _user;
            }

            set
            {
                if (value == null)
                {
                    throw new ArgumentException("User can not be null");
                }
                else
                {
                    _user = value;
                }
            }
        }

        private DateTime _date;
        public DateTime Date
        {
            get
            {
                return _date;
            }

            set
            {
                _date = value;
            }
        }

        private decimal _amount;
        public decimal Amount
        {
            get
            {
                return _amount;
            }

            set
            {
                _amount = value;
            }
        }

        public abstract void Execute();

        public override string ToString() // ToString() er en virtuel metode i Object.ToString();
        {
            return ($"Transaction ID: {TransactionID}, User: {User.Username}, Balance: {User.Balance} Date: {Date}");
        }


    }
}
