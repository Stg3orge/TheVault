using System;
using System.Collections.Generic;
using VirtualAbstractStart.Model;

namespace VirtualAbstractStart
{
    class ZooManager
    {
        static void Main(string[] args)
        {

            // Instantiate
            Animal dog1 = new Dog("Dog","Labrador");
            Animal cat1 = new Cat("Cat","Siemese");

            // Insert animals in list
            List<Animal> animals = new List<Animal>() { dog1, cat1 };

            foreach (Animal ani in animals)
            {
                Console.WriteLine(ani);
                ani.PerformTrick();

                if (ani is Dog)
                {
                    ani.FeedAnimal("bones");
                }
                if (ani is Cat)
                {
                    ani.FeedAnimal("catfood");
                }
            }

            Console.ReadKey();
        }
    }
}
