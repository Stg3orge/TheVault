using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseFirstCsharp
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = args[0];
            string name2 = args[1];

            if (args.Length == 0)
            {
                Console.WriteLine("ITS EMPTY");
            }
            else
            {
                Console.WriteLine("Hello, " + name2);
                Console.WriteLine("Hello, " + name);
            }


            Console.ReadLine();



        }
    }
}
