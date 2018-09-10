using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseJavaToCSharp.model
{
    public class Person
    {
        private string name;
        private int yearOfBirth;
        public Person(string name, int yearOfBirth)
        {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
        public override string ToString()
        {
            string personStr = name + " born " + yearOfBirth;
            return personStr;
        }
    }
}
