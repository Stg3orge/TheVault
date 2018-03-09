/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core;
using NEWexam2016.Core.Exceptions;
using NEWexam2016.Core.Stregsystem.EventHandling;

namespace NEWexam2016.Core.Stregsystem
{
    class StregsystemCLI : IStregsystemUI
    {
        public IStregsystem Stregsystem
        {
            get;
        }

        bool Running = false; // Til at styre om programmet skal køre eller ej

        public StregsystemCLI(IStregsystem stregsystem)
        {
            Stregsystem = stregsystem;
            User.OnUserBalanceNotification += PrintLowBalance; // Et event der får en lokal metode (PrintLowBalance) sat på et event
        }

        public static void PrintLowBalance(User user, decimal balance)
        {
            Console.WriteLine($"User: {user}, with {balance} is getting low on funds.");
        }

        // 1. Define a delegate
        // 2. Define an event based on that delegate
        // 3. Raise the event

        public event EventHandler<CommandEventArgs> CommandEntered; // CommandEntered er et event der skal rejses når CommandEventArgs får tildelt data, heri en string command
        protected virtual void OnCommandEntered(string command) // En skik i .NET at gøre sine Event Publisher Methods protected og virtual samt angive "On" "Hvad sker der"
        {
            if (CommandEntered != null) // Delegate Invoke, er der nogen command?
            {
                // new CommandEventArgs siger til event handleren at den skal holde øje med Command = command parameteren
                CommandEntered(this, new CommandEventArgs() { Command = command });
            }
        }

        public void DisplayInsufficientFunds()
        {
            Console.WriteLine("Could not purchase product, price exceeded users balance.");
        }

        public void DisplayProductNotActive()
        {
            Console.WriteLine("Specified product was not active and could not be purchased.");
        }

        public void Close()
        {
            Console.WriteLine("Program closing...");
            Running = false;
        }

        public void DisplayAdminCommandNotFoundMessage(string adminCommand)
        {

            Console.WriteLine($"Admin command not recognized: {adminCommand}");
        }

        public void DisplayGeneralError(string errorString)
        {
            Console.WriteLine($"Error: {errorString}");
        }

        public void DisplayProductNotFound(string product)
        {
            Console.WriteLine($"Specified product could not be found: {product}");
        }

        public void DisplayTooManyArgumentsError(string command)
        {
            Console.WriteLine($"Too many arguments specified: {command}");
        }

        public void DisplayUserBuysProduct(BuyTransaction transaction)
        {
            Console.WriteLine($"{transaction.User} bought item: {transaction.Product} for {transaction.Amount} DKK.");
        }

        public void DisplayUserInfo(User user)
        {
            Console.WriteLine($"{user}");
        }

        public void DisplayUserNotFound(string username)
        {
            Console.WriteLine($"User was not found based on username: {username}");
        }

        public void PrintActiveProducts()
        {
            foreach (Product product in Stregsystem.ActiveProducts)
            {
                Console.WriteLine(product.ToString());
            }
        }

        public void AdminCommands()
        {
            Console.WriteLine("Admin commands consist of: ");
            Console.WriteLine(":quit, :activate, :deactivate, :addcredits");
            Console.WriteLine("':quit' will exit the program. ':activate' followed by a valid product ID will activate the product.");
            Console.WriteLine("':deactivate' followed by a valid product ID will deactivate the product.");
            Console.WriteLine("':addcredits' followed by a valid amount will add the amount specified to the user.");
        }

        public void NormalCommands()
        {
            Console.WriteLine("Commands consists of: ");
            Console.WriteLine("Type a valid username to view info about the user.");
            Console.WriteLine("Type a valid username followed by a product's ID to quickbuy it.");
        }

        public void BootMenu() // Det primære konsol vindue og hvad der bliver printet hver gang
        {
            while (Running)
            {
                Console.Clear();

                PrintActiveProducts();
                AdminCommands();
                NormalCommands();
                Console.WriteLine("Enter a command: ");

                OnCommandEntered(Console.ReadLine());

                Console.ReadKey();

            }
        }

        public void Start()
        {
            Running = true;
            BootMenu();
        }
    }
}
