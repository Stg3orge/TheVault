using System;

namespace OOP2016_Kursusgang_3
{
    class Person
    {
        public string Fornavn;
        public string Efternavn;
        public int Alder;

        public Person FarKim;
        public Person FarfarPeder;
        public Person MorKatrine;
        public Person MorfarHarry;
        public Person MormorEllen;

        public Person(string Fornavn, string Efternavn, int Alder) // constructor
        {
            this.Fornavn = Fornavn;
            this.Efternavn = Efternavn;
            this.Alder = Alder;
        }

        public void printPerson()
        {
            Console.WriteLine("Navn: {0}\nEfternavn: {1}\nAlder: {2}\n", Fornavn, Efternavn, Alder);
        }
    }
}
