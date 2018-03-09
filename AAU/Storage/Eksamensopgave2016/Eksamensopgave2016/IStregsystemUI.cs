/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

namespace Eksamensopgave2016
{
    public interface IStregsystemUI
    {

        void DisplayUserNotFound(string username);
        void DisplayProductNotFound(int product);
        void DisplayUserInfo(User user);
        void DisplayTooManyArgumentsError(string command);
        void DisplayAdminCommandNotFoundMessage(string adminCommand);
        void DisplayUserBuysProduct(BuyTransaction transaction);
        void DisplayUserBuysProduct(int count, BuyTransaction transaction);
        void Close();
        void DisplayInsufficientCash(User user, Product product);
        void DisplayGeneralError(string errorString);
        event StregsystemEvent CommandEntered;

        void DisplayUserNotFound();
        void DisplayNotaValidProductId();
        void DisplayInsufficientCash();
        void Stregsystem_UserBalanceWarning(User user, decimal balance);
        void DisplayGeneralError();
        void DisplayNotaValidAmountOfProducts();

        void Start(StregsystemController commandParser);
        void DisplayCommandNotWorking();
        void DisplayAdminCommandNotFoundMessage();
        void DisplayProductNotFoundById();
        void DisplayNotaValidAmount();
        void DisplayError(string message);
        void DisplayInsufficientCash(BuyTransaction buyTransaction);
    }
}