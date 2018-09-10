using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectInitialization
{
    public class Person
    {
        private string name;
        private DateTime birthdate;

        //public Person()
        //{

        //}

        //public Person(string n)
        //{
        //    this.name = n;
        //}

        //public Person(string n, DateTime birthdate)
        //{
        //    this.name = n;
        //    this.birthdate = birthdate;
        //}

        public string Name
        {
            get { return name; }
            set { name = value; }
        }


        public DateTime BirthDate
        {
            get { return birthdate; }
            set { birthdate = value; }
        }

        public override string ToString()
        {
            return "Name: " + Name + ", " + BirthDate.ToShortDateString();
        }
    }
}
