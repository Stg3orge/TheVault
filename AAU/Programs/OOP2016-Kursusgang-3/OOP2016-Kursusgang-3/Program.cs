namespace OOP2016_Kursusgang_3
{
    class Program
    {
        static void Main(string[] args)
        {

            Person Jeg = new Person("Jacob", "Thomsen", 21);

            Jeg.FarKim = new Person("Kim", "Thomsen", 50);

            Jeg.FarfarPeder = new Person("Børge", "Thomsen", 70);

            // Jeg.Far.Fornavn = "Kim";
            // Jeg.Far.Efternavn = "Thomsen";
            // Jeg.Far.Alder = 50;

            Jeg.MorKatrine = new Person("Katrine", "Jensen", 51);

            Jeg.MorKatrine.MormorEllen = new Person("Ellen", "Handberg", 69);

            Jeg.MorKatrine.MorfarHarry = new Person("Harry", "Handberg", 74);

            Jeg.printPerson();
            Jeg.FarKim.printPerson();
            Jeg.FarKim.FarfarPeder.printPerson();

            System.Console.ReadKey();

            // Jeg.Mor.Mor = new Person();
            // Jeg.Katrine.Mormor. = new Person();

        }
    }
}
