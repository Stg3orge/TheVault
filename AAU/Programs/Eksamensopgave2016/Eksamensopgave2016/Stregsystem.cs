/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using Eksamensopgave2016.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Eksamensopgave2016
{
    public delegate bool StregsystemEvent(); // Delegate to point to event

    public class Stregsystem : IStregsystem
    {
        public List<Product> AllProducts { get; set; }

        public List<Product> activeProducts = new List<Product>();

        public List<Transaction> transactions = new List<Transaction>();

        public List<User> userList { get; set; }

        public Stregsystem() // Constructor
        {
            AllProducts = new List<Product>();
            ProductList = new ReadFile();
            userList = new List<User>();
            AllProducts = ProductList.InitializeProducts();
        }

        public IEnumerable<Product> ActiveProducts
        {
            get
            {
                foreach (Product productitem in AllProducts)
                {
                    if (productitem.Active == true)
                    {
                        if (!activeProducts.Contains(productitem))
                        {
                            activeProducts.Add(productitem);
                        }
                    }
                }
                return activeProducts;
            }
        }

        public ReadFile ProductList
        {
            get;
            set;
        }

        public event UserBalanceNotification UserBalanceWarning; // Event created in StregsystemCLI

        AddTransactionToLog writeTransactionsToLog = new AddTransactionToLog();

        // Enables user to add credits
        public void AddCreditsToAccount(User user, int amount)
        {
            DateTime tmpdate = DateTime.Now; // local variable for date of transaction
            InsertCashTransaction insertcash = new InsertCashTransaction(user, tmpdate, amount);
            insertcash.executeInsertMethod(user);
            writeTransactionsToLog.WriteTransactionFileToLog(insertcash);
        }

        // Enables user to purchase a product
        public BuyTransaction BuyProduct(User user, Product product, int count)
        {
            BuyTransaction buyTransaction = new BuyTransaction(user, product.productPriceTag, product);
            buyTransaction.executeBuyMethod(user, product);
            writeTransactionsToLog.WriteTransactionFileToLog(buyTransaction);
            return buyTransaction;
        }

        // Makes the admin command :activate able to activate any ID on the product list
        public void SetProductActive(int id)
        {
            foreach (Product product in AllProducts.Where(product => product.productID == id))
            {
                product.Active = true;
                return;
            }
            throw new Exception("There is no product with that id");
        }

        // Makes the admin command :deactivate able to activate any ID on the product list who are active
        public void DeactivateProduct(int id)
        {
            foreach (Product product in AllProducts.Where(product => product.productID == id))
            {
                product.Active = false;
                return;
            }
        }

        public Product GetProductByID(int _productID) // Return product depending on whether or not the ID is found to be the same
        {
            foreach (Product product in AllProducts)
            {
                if (product.productID == _productID)
                {
                    return product;
                }
            }
            throw new Exception("The product was not found");
        }

        public IEnumerable<Transaction> GetTransactions(User user, int count)
        {
            List<Transaction> getTransactions = transactions.Where(transaction => string.Equals(transaction.userTransaction, user.userName)).ToList();

            getTransactions.Reverse(); // To pseudo-sort the list of transactions

            if (getTransactions.Count > 10)
            {
                getTransactions.RemoveRange(count, getTransactions.Count - 1);
            }
            return getTransactions;
        }

        // Not Implemented because of GetUserByUsername

        /* public User GetUser(Func<User, bool> predicate)
        {
            throw new NotImplementedException();
        }
        */

        public void ExecuteTransaction(Transaction _transactions)
        {
            if (_transactions.userTransaction.Balance >= _transactions.amountTransaction)
            {
                transactions.Add(_transactions);
            }
        }

        public User GetUserByUsername(string username) // Attempts to retrieve user made in UserList class by comparing usernames from User class
        {
            foreach (User user in userList)
            {
                if (string.Equals(user.userName, username))
                {
                    return user;
                }
            }

            throw new Exception("User does not exist in the list"); // Concerning errors and such, in the future explain why the fault is happening, easier for debugging
        }

    }
}
