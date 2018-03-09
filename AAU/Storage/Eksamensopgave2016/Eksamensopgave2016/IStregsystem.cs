/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System.Collections.Generic;

namespace Eksamensopgave2016
{
    public interface IStregsystem
    {
        // Interface for Stregsystem class

        IEnumerable<Product> ActiveProducts { get; }
        List<Product> AllProducts { get; set; }
        ReadFile ProductList { get; set; }
        void AddCreditsToAccount(User user, int amount);
        BuyTransaction BuyProduct(User user, Product product, int count);
        Product GetProductByID(int productID);
        IEnumerable<Transaction> GetTransactions(User user, int count);
        // User GetUser(Func<User, bool> predicate);
        User GetUserByUsername(string username);
        event UserBalanceNotification UserBalanceWarning;
        void ExecuteTransaction(Transaction _transactions);

        List<User> userList { get; set; }

        void SetProductActive(int obj);
        void DeactivateProduct(int id);
    }
}