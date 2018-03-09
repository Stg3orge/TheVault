/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;
using System.Collections.Generic;
using System.Linq;

namespace Eksamensopgave2016
{
    public class StregsystemController
    {

        private IStregsystem stregsystem;
        private IStregsystemUI Ui;
        private Dictionary<string, Delegate> adminCommand;

        public StregsystemController(IStregsystemUI ui, IStregsystem stregsystem)
        {
            this.stregsystem = stregsystem;
            Ui = ui;
            adminCommand = new Dictionary<string, Delegate>();
            FillDictionary();
        }
        public void ParseCommand(string command)
        {
            string[] stringParts = command.Split(' ');

            if (stringParts[0].Contains(':'))
            {
                AdminCommands(stringParts);
                return;
            }

            switch (stringParts.Count())
            {
                case 1:
                    foreach (User user in stregsystem.userList)
                    {
                        if (stringParts[0] == user.userName)
                        {
                            Ui.DisplayUserInfo(user);
                            return;
                        }
                    }
                    Ui.DisplayUserNotFound();
                    break;
                case 2: // one transaction
                    {
                        User user;
                        Product product;
                        BuyTransaction transaction;
                        int id = 0;

                        Int32.TryParse(stringParts[1], out id);

                        if (id < 1)
                        {
                            Ui.DisplayNotaValidProductId();
                        }
                        try
                        {
                            user = stregsystem.GetUserByUsername(stringParts[0]);
                            product = stregsystem.GetProductByID(id);
                            transaction = new BuyTransaction(user, product.productPriceTag, product);
                            if (user.Balance > transaction.amountTransaction)
                            {
                                Ui.DisplayUserBuysProduct(transaction as BuyTransaction);
                            }
                            else
                            {
                                Ui.DisplayInsufficientCash();
                            }
                            user.Balance = transaction.executeBuyMethod(user, product);
                            if (user.Balance < 50)
                            {
                                Ui.Stregsystem_UserBalanceWarning(user, user.Balance);
                            }


                        }
                        catch
                        {
                            Ui.DisplayGeneralError();
                            return;
                        }
                        break;
                    }
                case 3: // For some reason this wont allow purchase of more than 2 products at a time
                    {
                        int id = 0;
                        int count = 0;
                        User user;
                        Product product;
                        BuyTransaction transaction;

                        Int32.TryParse(stringParts[2], out id); // Write ID

                        if (id < 1)
                        {
                            Ui.DisplayNotaValidProductId();
                        }

                        Int32.TryParse(stringParts[1], out count); // When written in prompt stringParts seperates inputs with a space, Write number of items

                        if (count < 1)
                        {

                            Ui.DisplayNotaValidAmountOfProducts();
                        }

                        try
                        {
                            user = stregsystem.GetUserByUsername(stringParts[0]); // Input of user through GetUserByUsername Method
                            product = stregsystem.GetProductByID(id); // retrieves product id
                            transaction = stregsystem.BuyProduct(user, product, count); // purchase of actual product
                            if (user.Balance > transaction.amountTransaction)
                            {
                                Ui.DisplayUserBuysProduct(transaction as BuyTransaction); // Writes to prompt window if purchase was completed
                            }
                            else
                            {
                                Ui.DisplayInsufficientCash(); // if you dont have enough cash
                            }
                            user.Balance = transaction.executeBuyMethod(user, product); // actually buys the item
                            if (user.Balance < 50)
                            {
                                Ui.Stregsystem_UserBalanceWarning(user, user.Balance);
                            }

                        }
                        catch
                        {
                            Ui.DisplayCommandNotWorking(); // writes to prompt if command wasnt recoqnised
                            return;
                        }
                        break;
                    }
                default:
                    Ui.DisplayGeneralError();
                    break;
            }
        }

        public bool DigitsOnly(string part) // Ensures only digits between 0 and 9 on string part
        {
            return part.All(digitsInt => digitsInt >= '0' && digitsInt <= '9');
        }

        private void AdminCommands(string[] stringParts) // method to manipulate admin commands
        {
            int productID = 0;
            int amount = 0;
            User user;

            if (!adminCommand.ContainsKey(stringParts[0]))
            {
                Ui.DisplayAdminCommandNotFoundMessage();
                return;
            }

            try
            {
                switch (stringParts.Count()) // Basically does the same for admin commands as for regular transaction commands
                {
                    case 1:
                        adminCommand[stringParts[0]].DynamicInvoke();
                        break;

                    case 2:
                        Int32.TryParse(stringParts[1], out productID);

                        if (productID < 1)
                        {
                            Ui.DisplayProductNotFoundById();
                        }
                        else
                        {
                            adminCommand[stringParts[0]].DynamicInvoke(productID);
                        }
                        break;

                    case 3:
                        user = stregsystem.GetUserByUsername(stringParts[1]);
                        Int32.TryParse(stringParts[2], out amount);
                        if (amount < 1)
                        {
                            Ui.DisplayNotaValidAmount();
                        }
                        else
                        {
                            adminCommand[stringParts[0]].DynamicInvoke(user, amount);
                        }
                        break;

                    default:
                        Ui.DisplayAdminCommandNotFoundMessage();
                        break;
                }
            }
            catch (Exception error)
            {
                Ui.DisplayError(error.Message);
            }
        }

        // admin commands for prompt window, not implemented is buying a product on credit
        private void FillDictionary()
        {
            adminCommand.Add(":quit", new Action(Ui.Close));
            adminCommand.Add(":activate", new Action<int>(stregsystem.SetProductActive));
            adminCommand.Add(":deactivate", new Action<int>(stregsystem.DeactivateProduct));
            adminCommand.Add(":addcredits", new Action<User, int>(stregsystem.AddCreditsToAccount));
        }
    }
}
