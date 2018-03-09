using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ExceptionServices;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace BOOTLCSharpProgram
{
    class Program
    {
        private static int firstx;
        private static int secondx;

        private static bool booleanx;

        static int Addition()
        {
            int sum;
            sum = firstx + secondx;
            return sum;
        }

        public static string print()
        {
            Console.WriteLine(Avv);
            return Avv;
        }

        static bool Check()
        {
            booleanx = false;

            int count;
            count = 1;

            while (count < 10)
            {
                count = count + 1;

                if (count == 10)
                {
                    booleanx = true;
                }
            }
            if (booleanx == true)
            {
                return booleanx;
            }
            return false;
        }

        static void Main(string[] args)
        {
            firstx = 10;
            secondx = 20;

            int result;
            result = Addition();

            bool complete;
            complete = Check();

            if (complete == true)
            {
                result = 50;
            }

        }
    }
}
