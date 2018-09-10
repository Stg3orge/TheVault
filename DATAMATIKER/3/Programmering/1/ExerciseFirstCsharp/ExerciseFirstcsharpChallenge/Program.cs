using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseFirstcsharpChallenge
{
    class Program
    {
        static void Main(string[] args)
        {
            int counter = 0;
            if (args.Length != 0)
            {
                foreach (string element in args)
                {
                    Console.WriteLine(element);
                    counter += element.Length;
                }

                Console.WriteLine("-----------------");
                Console.WriteLine("Number of entries: " + args.Length);
                Console.WriteLine("Number of characters: " + counter);
            }
            else
            {
                Console.WriteLine("Error - no arguments");
            }

            Console.ReadLine();

        }
    }
}
