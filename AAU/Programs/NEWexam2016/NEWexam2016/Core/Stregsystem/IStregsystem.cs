/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NEWexam2016.Core.Stregsystem
{
    public interface IStregsystem
    {
        IEnumerable<Product> ActiveProducts { get; }

        List<Product> Products { get; set; }

        InsertCashTransaction AddCreditsToAccount(User user, decimal amount);

        BuyTransaction BuyProduct(User user, Product product);

        Product GetProductByID(int productID);

        IEnumerable<Transaction> GetTransactions(User user, int count);

        User GetUsers(Func<User, bool> predicate);

        User GetUserByUsername(string username);

        void ActivateProduct(int ID);

        void DeactivateProduct(int ID);

        void CreditsOn(int ID);

        void CreditsOff(int ID);


    }
}
