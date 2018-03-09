/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System;

namespace Eksamensopgave2016
{
    class StregsystemCLI : IStregsystemUI
    {
        public Stregsystem stregsystem { get; }
        bool programRunning;

        public StregsystemCLI(Stregsystem _stregsystem) // Entire systemCLI is communication with user as specified in project
        {
            this.stregsystem = _stregsystem;
            stregsystem.UserBalanceWarning += Stregsystem_UserBalanceWarning;
            // Subscribes to event, which contains below lieing method
            // += er at subscribe
            programRunning = true;
        }

        public void Stregsystem_UserBalanceWarning(User user, decimal balance)
        {
            if (user.Balance < 50)
            {
                Console.WriteLine($"{user.userName} is getting low on balance for purchasing products. Balance at: {user.Balance}");
            }
        }

        public event StregsystemEvent CommandEntered; // not implemented

        public void Close()
        {
            Console.WriteLine("Shutting down.");
            programRunning = false;
        }



        public void PrintActiveProducts()
        {
            foreach (Product product in stregsystem.AllProducts) // Through foreach product prints every active product
            {
                if (product.Active == true)
                {
                    Console.WriteLine(product.ToString());
                }
            }
        }

        public void DisplayAdminCommandNotFoundMessage(string adminCommand)
        {
            Console.WriteLine("Command does not exist.");
        }

        public void DisplayAdminCommandNotFoundMessage()
        {
            Console.WriteLine("Command does not exist.");
        }

        public void DisplayGeneralError(string errorString)
        {
            Console.WriteLine("ERROR.");
        }

        public void DisplayInsufficientCash(BuyTransaction transanctions)
        {
            Console.WriteLine("Product could not be purchased, your balance is getting low.");
        }

        public void DisplayProductNotFound(int product)
        {
            Console.WriteLine($"The product: {product} was not validated.");
        }

        public void DisplayTooManyArgumentsError(string command)
        {
            Console.WriteLine("Overload of arguments, unable to continue.");
        }

        public void DisplayUserBuysProduct(BuyTransaction transaction)
        {
            Console.WriteLine($"User: {transaction.userTransaction.userName} confirmed transaction of: {transaction.productItem} transacted total: {transaction.amountTransaction} on the date: {transaction.Date}");
        }

        public void DisplayUserInfo(User user)
        {
            Console.WriteLine($"User: {user.userName}, Name: {user.firstName} {user.lastName}, Balance: {user.Balance}");
        }

        public void DisplayUserNotFound(string username)
        {
            Console.WriteLine($"User: {username} was not found.");
        }

        public void DisplayUserNotFound()
        {
            Console.WriteLine("User was not found.");
        }

        public void Start(StregsystemController commandParser) // Starts controller class
        {
            Startup(commandParser);
        }

        public void DisplayCommandNotWorking()
        {
            Console.WriteLine("Command does not compute.");
        }

        public void DisplayNotaValidProductId()
        {
            Console.WriteLine("Invalid Product ID.");
        }

        public void NormalCommands()
        {
            Console.WriteLine("Commands:");
            Console.WriteLine("Insert username to view user, or username followed by which product ID to buy it.");
        }

        public void AdminCommands()
        {
            Console.WriteLine("Admin commands consist of: ");
            Console.WriteLine(":quit, :activate, :deactivate, :addcredits");
        }

        public void DisplayNotaValidAmount()
        {
            Console.WriteLine("Invalid amount inserted.");
        }

        public void DisplayProductNotFoundById()
        {
            Console.WriteLine("Product was not located based on ID input.");
        }

        public void DisplayGeneralError()
        {
            Console.WriteLine("ERROR.");
        }

        public void DisplayNotaValidAmountOfProducts()
        {
            Console.WriteLine("Not a valid amount of products.");
        }

        public void DisplayInsufficientCash()
        {
            Console.WriteLine("Product could not be purchased, too low balance.");
        }

        public void Startup(StregsystemController parser) // General prompt for executing every command, clears on keypress afterwards
        {
            while (programRunning)
            {
                Console.Clear();
                PrintActiveProducts();
                Console.WriteLine("Enter a command");
                AdminCommands();
                NormalCommands();
                parser.ParseCommand(Console.ReadLine());
                Console.ReadKey();

            }
        }

        public void DisplayUserBuysProduct(int count, BuyTransaction transaction) // Not implemented
        {
            throw new NotImplementedException();
        }

        public void DisplayInsufficientCash(User user, Product product) // not implemented
        {
            throw new NotImplementedException();
        }

        public void DisplayError(string error) // ERROR !!
        {
            Console.WriteLine($"ERROR. {error}");
        }
    }
}