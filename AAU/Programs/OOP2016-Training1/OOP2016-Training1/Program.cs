using System;

namespace OOP2016_Training1
{
    class Program
    {
        static void Main(string[] args)
        {
            // Mit workspace
            

            // variables randomly, use these
            int minVariabel = 10;
            int minVariabel2 = 5;
            float minFloat = 1.5f;
            double minDouble = 40.55;
            char minChar = '#';


            double x = 1 / 2.0;
            int y = 1 / 2;

            Console.WriteLine($"Dank memes {minVariabel} kk {minFloat} ok {minDouble} char is {minChar}");
            Console.WriteLine($"X is: {x} and Y is: {y}");


            // Simple bool use
            bool minBool = minVariabel < minVariabel2;

            if(minBool == true)
            {
                Console.WriteLine("Dank Memes");
            }
            else
                Console.WriteLine("No Dank Memes BibleThump");

            Console.WriteLine($"Er minVariabel mindre end minVariabel2? {minBool}");


            /*******
            KAN IKKE LAVE ASSIGNMENT TIL DATATYPER I CONDITIONS
            if(int garbageInt = 5 < garbageIntTwo = 7){

            }
            ********/

            Console.ReadKey();

            // Slut workspace
        }
    }
}
