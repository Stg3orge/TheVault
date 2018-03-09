using System;

namespace OOP2016_Kursusgang_2
{
    class Opgave1ab
    {
        public static string inputNumber;

        static void Main(string[] args)
        {
            Console.WriteLine("Please type in a number: ");
            inputNumber = Console.ReadLine();
            //int outputNumber;
            //bool parsedFromInputNumber = Int32.TryParse(inputNumber, out outputNumber);
            int outputNumber;

            /**************************************************************************
            *****TryParse kaster alle exceptions væk mens Parse kan man lave arguments til eventuelle errors:
            *****https://msdn.microsoft.com/en-us/library/b3h1hf19(v=vs.110).aspx
            **************************************************************************/

            try
            {
                outputNumber = Int32.Parse(inputNumber);
            }
            catch (ArgumentNullException)
            {
                Console.WriteLine("Fejl - NULL");
            }
            catch (FormatException)
            {
                Console.WriteLine("{0}: Bad Format", inputNumber);
            }
            catch (OverflowException)
            {
                Console.WriteLine("{0}: Overflow", inputNumber);
            }
            Console.WriteLine("You inputted {0} and maybe you had an error since input is parsed from string to an Int32", inputNumber);

            Opgave1c c = new Opgave1c();
            c.opgaveC();
        }
    }
    public class Opgave1c
    {
        public void opgaveC()
        {
            Opgave1ab variable;
            variable = new Opgave1ab();

            Console.WriteLine("Write any number to convert to hexidecimal: ");
            Opgave1ab.inputNumber = Console.ReadLine();
            int outputNumber = Int32.Parse(Opgave1ab.inputNumber);
            Console.WriteLine("Hex of parsed number inputted is: {0:X}", outputNumber);
            Console.ReadKey();
        }
    }
}
