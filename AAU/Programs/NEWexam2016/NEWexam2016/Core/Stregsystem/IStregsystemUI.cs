/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core.Stregsystem;
using NEWexam2016.Core.Stregsystem.EventHandling;

namespace NEWexam2016.Core.Stregsystem
{
    interface IStregsystemUI
    {
        void DisplayUserNotFound(string username);
        void DisplayProductNotFound(string product);
        void DisplayUserInfo(User user);
        void DisplayTooManyArgumentsError(string command);
        void DisplayAdminCommandNotFoundMessage(string adminCommand);
        void DisplayUserBuysProduct(BuyTransaction transaction);
        void Close();
        void DisplayGeneralError(string errorString);
        void Start();
        void DisplayProductNotActive();
        void DisplayInsufficientFunds();

        event EventHandler<CommandEventArgs> CommandEntered;
    }
}
