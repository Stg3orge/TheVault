using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseJavaToCsharpChallenge
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee emp1 = new Employee("Hans Hansen");
            emp1.addFavoriteWord("Git");
            emp1.addFavoriteWord("Gut");
            emp1.addFavoriteWord("Got");

            Console.WriteLine("The favourite words of " + emp1.getEmployeeName() + " is");
            emp1.printAllWords();

            Console.ReadLine();
        }
    }
}
