using System;
using System.Collections.Generic;
using VirtualAbstractStart.Model;

namespace VirtualAbstractStart {
    class ZooManager {
        static void Main(string[] args) {

            // Instantiate

            // Insert animals in list
            List<Animal> animals = new List<Animal>() { dog1, cat1 };

            foreach(Animal ani in animals) {
                Console.WriteLine(ani);
                ani.PerformTrick();
                ani.FeedAnimal();
            }
            Console.ReadLine();
        }
    }
}
