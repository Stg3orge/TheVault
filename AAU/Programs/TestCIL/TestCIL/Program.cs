using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace TestCIL
{
    class Program
    {
        static void Main()
        {
            int first;
            int second;

            first = 10;
            second = 20;

            int result;
            result = first + second;

            bool check;
            check = false;

            int count;
            count = 1;

            while (count < 10)
            {
                count = count + 1;

                if (count == 10)
                {
                    check = true;
                }
            }
        }
    }
}
