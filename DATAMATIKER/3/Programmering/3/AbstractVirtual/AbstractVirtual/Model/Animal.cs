using System;

namespace VirtualAbstractStart.Model
{
    public abstract class Animal
    {

        public string Species
        {
            get; set;
        }
        public string Breed
        {
            get;
            set;
        }

        protected Animal(string species, string breed)
        {
            Species = species;
            Breed = breed;
        }

        public abstract void PerformTrick();

        public virtual void FeedAnimal(string feed)
        {
            Console.WriteLine("Yum " + feed);
        }

        public override string ToString() => $"{Species} - {Breed}";
    }
}
