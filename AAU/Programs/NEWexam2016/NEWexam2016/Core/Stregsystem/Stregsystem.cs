/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core;
using NEWexam2016.Core.Log;
using NEWexam2016.Core.Exceptions;

namespace NEWexam2016.Core.Stregsystem
{
    class Stregsystem : IStregsystem
    {
        TransactionLog transactionlog = new TransactionLog();

        public void LoadUsers()
        {
            Users.Add(new User("Carl", "Johnson", "cj22_", "cj@msn.com", 5000));
            Users.Add(new User("Jacob", "Thomsen", "stgeorge", "card@gmail.com", 400));
            Users.Add(new User("Ellen", "Handberg", "eh1", "eh1@gmail.com", 40));
            Users.Add(new User("Arnold", "Schwarzenegger", "ascali", "arnold@gmail.com", 25));
        }

        public List<Product> Products
        {
            get; set;
        }

        public List<Product> ActiveProductsList = new List<Product>();

        public List<User> Users
        {
            get; set;
        }

        public List<Transaction> CompletedTransactions = new List<Transaction>();

        public Stregsystem() // Constructor
        {
            Products = new List<Product>();
            ReadFromFile = new ReadFile();
            Users = new List<User>();
            LoadUsers();
            Products = ReadFromFile.ReadProducts();
        }

        public ReadFile ReadFromFile
        {
            get; set;
        }

        public IEnumerable<Product> ActiveProducts
        {
            get
            {
                ActiveProductsList.Clear();

                foreach (Product product in Products)
                {
                    if (product.Active == true)
                    {
                        ActiveProductsList.Add(product);
                    }
                }

                return ActiveProductsList;
            }
        }

        public InsertCashTransaction AddCreditsToAccount(User user, decimal amount)
        {
            InsertCashTransaction addcreditstoaccount = new InsertCashTransaction(user, DateTime.Now, amount);

            addcreditstoaccount.Execute();

            transactionlog.WriteTransactionLog(addcreditstoaccount); // Bruger ToString() i Transaction

            CompletedTransactions.Add(addcreditstoaccount);

            return addcreditstoaccount;
        }

        public BuyTransaction BuyProduct(User user, Product product)
        {
            BuyTransaction buyproduct = new BuyTransaction(user, DateTime.Now, product);

            buyproduct.Execute();

            transactionlog.WriteTransactionLog(buyproduct);

            CompletedTransactions.Add(buyproduct);

            return buyproduct;
        }

        public Product GetProductByID(int productID)
        {
            foreach (Product product in Products)
            {
                if (product.ProductID == productID)
                {
                    return product;
                }
            }

            throw new ProductDoesNotExistException();
        }

        public IEnumerable<Transaction> GetTransactions(User user, int count)
        {                                                                // Lambda udtryk
            List<Transaction> gettransactions = CompletedTransactions.Where(transaction => string.Equals(transaction.User, user.Username)).ToList();

            if (gettransactions.Count > 10)
            {
                gettransactions.RemoveRange(count, gettransactions.Count - 1);
            }
            return gettransactions;
        }

        public User GetUserByUsername(string username)
        {
            foreach (User user in Users)
            {
                if (user.Username == username)
                {
                    return user;
                }
            }

            throw new UsernameDoesNotExistException();
        }

        public User GetUsers(Func<User, bool> predicate)
        {
            foreach (User user in Users)
            {
                if (predicate(user) == true)
                {
                    return user;
                }
            }

            throw new ArgumentException("User does not exist");
        }

        public void ActivateProduct(int ID)
        {
            GetProductByID(ID).Active = true;
        }

        public void DeactivateProduct(int ID)
        {
            GetProductByID(ID).Active = false;
        }

        public void CreditsOn(int ID)
        {
            GetProductByID(ID).CanBeBoughtOnCredit = true;
        }

        public void CreditsOff(int ID)
        {
            GetProductByID(ID).CanBeBoughtOnCredit = false;
        }
    }
}
