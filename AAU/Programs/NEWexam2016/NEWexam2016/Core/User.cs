/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace NEWexam2016.Core
{
    public class User : IComparable
    {

        public User(string firstname, string lastname, string username, string email, decimal balance)
        {
            Firstname = firstname;
            Lastname = lastname;
            Username = username;
            Email = email;
            Balance = balance;
            this._userID = User.Counter;
            User.Counter++;
        }

        private string _firstname;
        public string Firstname
        {
            get { return _firstname; }
            set
            {
                if (value == null)
                {
                    throw new ArgumentNullException("Firstname cannot be null");
                }
                else
                {
                    _firstname = value;
                }
            }
        }

        private string _lastname;
        public string Lastname
        {
            get { return _lastname; }
            set
            {
                if (value == null)
                {
                    throw new ArgumentNullException("Lastname cannot be null");
                }
                else
                {
                    _lastname = value;
                }
            }
        }

        private string _username;
        public string Username
        {
            get { return _username; }
            set
            {

                if (value == null)
                {
                    throw new ArgumentException("Username can not be null value");
                }
                else if (Regex.IsMatch(value, @"([a-z]|[0-9]|_|)*"))
                {
                    _username = value;
                }


            }
        }

        private string _email;
        public string Email
        {
            get { return _email; }
            set
            {
                if (value == null)
                {
                    throw new ArgumentException("Email can not be null value");
                }
                else if (Regex.IsMatch(value, @"([a-z]|[A-Z]|[0-9]|_|\.|-)+@([a-z]|[A-Z]|[0-9]|_)([a-z]|[A-Z]|[0-9]|\.|-)*(\.)+([a-z]|[A-Z]|[0-9]|\.|-)*([a-z]|[A-Z]|[0-9]|_)"))
                {
                    _email = value;
                }
            }
        }

        public delegate void UserBalanceNotification(User user, decimal balance);
        public static event UserBalanceNotification OnUserBalanceNotification; // Statisk event som delegaten peger på

        private decimal _balance;
        public decimal Balance
        {
            get { return _balance; }
            set
            {
                _balance = value;

                if (value < 50 && OnUserBalanceNotification != null) // Holder øje med om balance er under 50 
                {
                    OnUserBalanceNotification(this, value); // Rejser eventet med de nødvendige parametre fra Delegaten set ovenover, this = user, value = balance
                }
            }
        }

        static int Counter = 1;
        private int _userID;
        public int UserID
        {
            get
            {
                return _userID;
            }
            set
            {
                _userID = value;
            }
        }


        public override string ToString()
        {
            return ($"{Firstname}, {Lastname}, {Email}, {Balance}.");
        }

        public int CompareTo(object obj)
        {
            return UserID.CompareTo(obj); // En standard CompareTo på en brugers ID
        }

        public override bool Equals(object obj)
        {

            User user = (User)obj;

            return user.UserID.Equals(this.UserID); // Er det specificerede object det samme som dette (this.UserID)
        }

        public override int GetHashCode()
        {
            return UserID;
        }
    }
}
