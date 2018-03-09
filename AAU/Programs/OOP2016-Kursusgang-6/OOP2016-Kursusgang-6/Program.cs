using System;

namespace OOP2016_Kursusgang_6
{
    class Program
    {
        static void Main(string[] args)
        {
            Pair<int> dickbutt = new Pair<int>(5, 10);
            Console.WriteLine("{0} {1}", dickbutt.First, dickbutt.Second);
            dickbutt.Swap();
            Console.WriteLine($"First er: {dickbutt.First} og Second er: {dickbutt.Second}");
            Console.ReadKey();
        }
    }
}
