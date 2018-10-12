using System;

namespace VirtualAbstractStart.Model
{
    public class Cat : Animal
    {
        //Strings er immutable
        public Cat(string species, string breed) : base(species, breed)
        {
        }

        public override void PerformTrick()
        {
            Console.WriteLine("Miauw!");
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
