/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;

namespace Eksamensopgave2016
{
    public class User : IComparable
    {
        // constructor to set up a user
        public User(string _firstname, string _lastname, string _username, string _email, decimal _balance)
        {
            firstName = _firstname;
            lastName = _lastname;
            userName = _username;
            Email = _email;
            Balance = _balance;
            this.eachUsersID = User.staticUserIDCounter;
            User.staticUserIDCounter++;
        }


        // User ID starts at 1 and countUserID is a property to deal with different users
        static private int staticUserIDCounter = 1; // Has to be static and in the constructor it is incremented to ensure different user ids
        private int eachUsersID;
        public int countUserID
        {
            get { return staticUserIDCounter; }
            private set { eachUsersID = staticUserIDCounter; }
        }

        // First name of user that cant be null
        private string firstname;
        public string firstName
        {
            get
            {
                return firstname;
            }
            private set
            {
                firstname = value;
                if (firstName == null)
                {
                    throw new System.Exception("ERRORCODE 100: Cannot assign null value to firstName");
                }
            }
        }

        // Last name of user that cant be null
        private string lastname;
        public string lastName
        {
            get
            {
                return lastname;
            }
            private set
            {
                lastname = value;
                if (lastName == null)
                {
                    throw new System.Exception("ERRORCODE 101: Cannot assign null value to lastName");
                }
            }
        }

        // Property for username using Regex package to check if the limitations match the input for username otherwise throws an exception
        private string username;
        public string userName
        {
            get
            {
                return username;
            }
            private set
            {
                username = value;
                string stringChecker = @"^[a-z0-9_]+$";
                if (!System.Text.RegularExpressions.Regex.IsMatch(value, stringChecker))
                {
                    throw new System.FormatException("You can only use letters a-z and underscore, must be lowercase letters and may only contain numbers from 0-9");
                }
            }

        }

        // Email formatting defined with Regex utility, seperating email into three parts of local, @ and domain which cannot have excess characters over 3
        private string email;
        public string Email
        {
            get
            {
                return email;
            }
            private set
            {
                email = value;
                System.Text.RegularExpressions.Regex emailRegex = new System.Text.RegularExpressions.Regex((@"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$"));
                System.Text.RegularExpressions.Match matchingEmail = emailRegex.Match(email);
                if (!matchingEmail.Success)
                {
                    throw new System.Exception("ERRORCODE 103: Email did not match the requirements for an email address, e.g. local@domain");
                }

            }
        }

        // decimal balance for users total budget
        private decimal balance;
        public decimal Balance
        {
            get
            {
                return balance;
            }
            set
            {
                balance = value;
            }
        }

        // Methods to compare user IDs, not utilized. Constructor ensures unique ids on program execution. This is evident in the transactionslog file
        public int CompareTo(object obj)
        {

            if (obj == null)
                return 1;

            User id = obj as User;

            if (id != null)
            {
                return this.countUserID.CompareTo(id.countUserID);
            }
            else
                throw new ArgumentException("ERRORCODE 104: ");
        }

        // override of Equals method, supposed to be used for comparing ids, however this is not utilized
        public override bool Equals(object obj)
        {
            User currentUser = obj as User;
            if (currentUser != null)
            {
                return Equals(currentUser.eachUsersID, eachUsersID);
            }
            else
            {
                throw new ArgumentException("ERRORCODE 105: ");
            }

        }

        // Retrieves had code of every users individual ID, not used
        public override int GetHashCode()
        {
            return (eachUsersID);
        }

        public override string ToString()
        {
            return string.Format($"name: {firstName} last name: {lastName} and email: {Email} and id: {this.eachUsersID}");
        }


    }
}
