using System;

namespace VirtualAbstractStart.Model
{
    public class Dog : Animal
    {
        public Dog(string species, string breed) : base(species, breed)
        {
        }

        public override void PerformTrick()
        {
            Console.WriteLine("Bark!");
        }

        public override void FeedAnimal(string feed)
        {
            base.FeedAnimal(feed);
        }

        public override string ToString()
        {
            return base.ToString();
        }
    }
}
