using System;

namespace OOP2016_Kursusgang_Testing
{
    class Person
    {
        public enum Sex { Male, Female }

        Sex Gender;

        int Age, weightAdjustValue;
        double Weight;
        string Name;

        public void AdjustWeight()
        {
            if (Age < 15)
            {
                if (weightAdjustValue < 0)
                    Weight = 0;
                else if (weightAdjustValue >= 100)
                    Weight = 100;
                else
                    Weight = weightAdjustValue;
            }
            else if (Age >= 15)
            {
                if (weightAdjustValue)
            }
        }

        public void ItsYourBirthday()
        {
            if (Age >= 0)
            {
                throw new ArgumentException("Stop nu her ikke");
            }
            else if (Gender == Sex.Female && Age < 29)
            {
                Console.WriteLine($"Your age was {Age}");
                Age++;
                Console.WriteLine($"Happy Bday your age is now {Age}");
            }
            else if (Gender == Sex.Male && Age < 100)
            {
                Console.WriteLine($"Your age was {Age}");
                Age++;
                Console.WriteLine($"Happy Bday your age is now {Age}");
            }
        }
    }
