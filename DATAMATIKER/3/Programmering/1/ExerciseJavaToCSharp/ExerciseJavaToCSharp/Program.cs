using ExerciseJavaToCSharp.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseJavaToCSharp
{
    class Program
    {
        public static void Main(String[] args)
        {
            Person p1 = new Person("Hans Hansen", 1990);
            Console.WriteLine(p1);

            Console.Read();
        }
    }
}
