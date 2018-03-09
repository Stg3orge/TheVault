/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core.Stregsystem.EventHandling;
using NEWexam2016.Core.Exceptions;

namespace NEWexam2016.Core.Stregsystem
{
    class StregsystemController
    {
        private IStregsystem Stregsystem;
        private IStregsystemUI Ui;

        // Dictionary er en System.Collections.Generic
        private Dictionary<string, Delegate> admincommands; //Key, Value. Et bibliotek med et alphabet og en bog under et bogstav

        private void FillAdminCommands()
        {
            admincommands.Add(":quit", new Action(Ui.Close)); // alle disse admincommands der bliver smidt ind er elements i mit dictionary
            admincommands.Add(":q", new Action(Ui.Close)); // De angiver en string (key) og en Action eller Func (Value)
            admincommands.Add(":activate", new Action<int>(Stregsystem.ActivateProduct)); // Kalder en metode i Stregsystem der aktiverer et product
            admincommands.Add(":deactivate", new Action<int>(Stregsystem.DeactivateProduct)); // Kalder en metode til at deactivate et product
            admincommands.Add(":creditson", new Action<int>(Stregsystem.CreditsOn));
            admincommands.Add(":creditsoff", new Action<int>(Stregsystem.CreditsOff));
            admincommands.Add(":addcredits", new Func<User, decimal, InsertCashTransaction>(Stregsystem.AddCreditsToAccount));
        }

        public StregsystemController(IStregsystem stregsystem, IStregsystemUI stregsystemUI) // Interfaces som parametre
        {
            Stregsystem = stregsystem; // Lokale variabler ovenover, sat til parametre
            Ui = stregsystemUI;        //                    ^

            Ui.CommandEntered += ParseCommand; // PareCommand er en metode der blivers midt på CommandEntered EventHandleren fra CLI

            admincommands = new Dictionary<string, Delegate>();
            FillAdminCommands();
        }

        // IKKE SIG MAN KUNNE BRUGE INVOKE KUN AT JEG BARE HAR BRUGT DYNAMIC, DYNAMIC FINDER SELV UD AF HVAD DEN SKAL SENDE IGENNEM
        public void ParseCommand(object sender, CommandEventArgs args)
        {
            string[] stringSpace = args.Command.Split(); // 'Command' er string fra CommandEventArgs

            if (args.Command.StartsWith(":")) // Er de Admin commands
            {
                try
                {
                    foreach (string key in admincommands.Keys)
                    {
                        if (key == stringSpace[0]) // Kigger i Dictionary på deres nøgle og ser om på plads 0 er det samme som nøglen
                        {
                            if (admincommands[key].GetType() == typeof(Action)) // Action er en metode uden parametre og return
                            {
                                if (stringSpace.Length == 1)
                                {
                                    admincommands[key].DynamicInvoke(); // Invoker det som dictionary specificerer
                                }
                                else
                                {
                                    Ui.DisplayTooManyArgumentsError(args.Command); // fra CLI
                                }
                            }
                            else if (admincommands[key].GetType() == typeof(Action<int>)) // Hvis nøglen specificerer en action<int>
                            {
                                if (stringSpace.Length == 2) // Hvis antallet af elementer i stringSpace arrayet er 2 ie: "stgeorge 11"
                                {
                                    admincommands[key].DynamicInvoke(Convert.ToInt32(stringSpace[1])); // lave den string man indtaster på plads 1 til en int
                                }
                                else
                                {
                                    Ui.DisplayTooManyArgumentsError(args.Command);
                                }
                            }                               // Func<> er en metode der kan specificere en return type her en User
                            else if (admincommands[key].GetType() == typeof(Func<User, decimal, InsertCashTransaction>))
                            {
                                if (stringSpace.Length == 3)
                                {
                                    admincommands[key].DynamicInvoke(Stregsystem.GetUserByUsername(stringSpace[1]), Convert.ToDecimal(stringSpace[2]));
                                }
                                else
                                {
                                    Ui.DisplayTooManyArgumentsError(args.Command);
                                }
                            }
                        }
                    }
                }
                catch (Exception e) { Ui.DisplayGeneralError(e.Message); } // Almighty, Kunne holde øje med hver og en type af exception her too

            }
            else
            {

                try
                {
                    User user = Stregsystem.GetUserByUsername(stringSpace[0]);

                    switch (stringSpace.Length)
                    {
                        case 1:
                            Ui.DisplayUserInfo(user);
                            break;

                        case 2:
                            Stregsystem.BuyProduct(user, Stregsystem.GetProductByID(Convert.ToInt32(stringSpace[1])));
                            break;

                        case 3:
                            for (int i = 0; i < Convert.ToInt32(stringSpace[2]); i++)
                            {
                                Stregsystem.BuyProduct(user, Stregsystem.GetProductByID(Convert.ToInt32(stringSpace[1])));
                            }
                            break;

                        default:
                            Ui.DisplayTooManyArgumentsError(args.Command);
                            break;
                    }
                }

                catch (UsernameDoesNotExistException) { Ui.DisplayUserNotFound(stringSpace[0]); }
                catch (NonActiveProductException) { Ui.DisplayProductNotActive(); }
                catch (InsufficientCreditsException) { Ui.DisplayInsufficientFunds(); }
                catch (Exception e) { Ui.DisplayGeneralError(e.Message); }
            }
        }
    }
}
