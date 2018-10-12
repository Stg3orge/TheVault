using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public class Person
    {
        public Person(string input)
        {
            Name = input;
        }

        public string Name { get; set; }
    }
}
