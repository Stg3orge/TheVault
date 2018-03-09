namespace OOP2016_Kursusgang_2_Opgave_2
{
    class Opgave2
    {
        static void Main(string[] args)
        {

        }

        static double Sum(double x1, double x2)
        {
            return x1 + x2;
        }

        static double Sum(double x1, double x2, double x3)
        {
            return x1 + x2 + x3;
        }

        static double Sum(params double[] numbers)
        {
            foreach (double item in numbers)
            {
                double sum = +item;
                return sum;
            }
            return sum;
        }
    }
}
