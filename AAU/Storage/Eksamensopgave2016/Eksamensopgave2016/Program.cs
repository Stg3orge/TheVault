/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

namespace Eksamensopgave2016
{
    //Delegate for notifying user of low balance
    public delegate void UserBalanceNotification(User user, decimal balance);

    class Program
    {
        static void Main(string[] args)
        {

            // Would have liked to use my UserList class here
            User Jacob = new User("Jacob", "Thomsen", "stgeorge", "cardisbunx@gmail.com", 49);
            User John = new User("John", "Cena", "johncenashow", "johncenaofficial@gmail.com", 150);


            Stregsystem stregsystem = new Stregsystem();
            stregsystem.userList.Add(John);
            stregsystem.userList.Add(Jacob);
            StregsystemCLI ui = new StregsystemCLI(stregsystem);
            StregsystemController sc = new StregsystemController(ui, stregsystem);

            ui.Start(sc);

            System.Console.ReadKey();
        }
    }
}
