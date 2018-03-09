using System;

namespace OOP2016_Kursusgang_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello. Type in your first name");
            string firstName = Console.ReadLine();
            Console.WriteLine("Hello. Type in your last name");
            string lastName = Console.ReadLine();
            Console.Clear();

            Console.WriteLine("Hello {0} {1}", firstName, lastName);
            GivingRandomNumber(lastName);
            Console.ReadKey();
        }
        private static void GivingRandomNumber(string lastName)
        {
            Console.WriteLine("Type in a number between 1 - 10");
            string inputStringTal = Console.ReadLine();
            int reeltTal;
            bool whileCheck = true;

            reeltTal = Int32.Parse(inputStringTal);
            // Random er en metode fra System lige som rand fra C næsten. new Random er allokering af plads
            Random r = new Random();
            // Next er også en funktion fra System der vælgeret tal mellem to andre lavet i syntaxen herunder 1 og 10
            int randomNummer = r.Next(1, 10);
            while (whileCheck == true)
            {
                if (reeltTal < 11 && reeltTal >= 1)
                {
                    if (reeltTal == randomNummer)
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("You did it!");
                        whileCheck = false;
                    }
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("You fked up, type in a new number: );
                        inputStringTal = Console.ReadLine();
                        reeltTal = Int32.Parse(inputStringTal);
                    }
                }
                else
                {
                    Console.WriteLine("Input was either above 10 or below 1, try again.");
                }

            }
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("Mr. {1}, Your number was: {0}", randomNummer, lastName);
        }
    }
}
