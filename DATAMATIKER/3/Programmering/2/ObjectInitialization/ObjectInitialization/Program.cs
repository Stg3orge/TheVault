using System;
using ObjectInitialization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectInitialization
{
    class Program
    {
        static void Main(string[] args)
        {
            Person per1 = new Person();

            //Person per2 = new Person("Jacob");
            Person per2 = new Person()
            {
                Name = "Jacob"
            };

            //Person per3 = new Person("James", new DateTime(1998, 04, 28));
            Person per3 = new Person()
            {
                Name = "James",
                BirthDate = new DateTime(1998, 02, 02)
            };


            //Person per4 = new Person("Flynn");
            Person per4 = new Person()
            {
                Name = "Flynn"
            };

            Console.WriteLine("Name: " + per1.Name);
            Console.WriteLine("Name: " + per2.Name);
            Console.WriteLine("Name: " + per3.Name + ", " + per3.BirthDate.ToShortDateString());
            Console.WriteLine("Name: " + per4.Name);
            Console.WriteLine("----------------");

            Console.WriteLine(per3.ToString()); 

            Console.ReadKey();
        }
    }
}
