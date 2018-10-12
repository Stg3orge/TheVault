using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortDelegate
{
    class ManageScores
    {

        static char delimiter = '-';
        //delegate void dickbButt(int[] input);

        static void Main(string[] args)
        {

            int[] scores = new int[] { 4, 2, 7, 4, 9, 13, 2, 1, 4, 0, 5 };

            // Display scores as entered in collection
            Console.WriteLine("Unsorted scores");
            Console.WriteLine(GetDisplayString(scores));

            // Display scores sorted by some order
            // Use BubleSort method - member og DelegateBubleSort class 

            Console.WriteLine("Sorted scores");

            //DelegateBubleSort.BubbleSort(scores, DelegateBubleSort.GreaterThan);
            //DelegateBubleSort.BubbleSort(scores, DelegateBubleSort.AlphabetOrder);
            DelegateBubleSort.BubbleSort(scores, DelegateBubleSort.EvenOddOrder);

            Console.WriteLine(GetDisplayString(scores));

            Console.Read();
        }

        private static string GetDisplayString(IEnumerable<int> nums)
        {
            StringBuilder sb = new StringBuilder();
            int counter = 0;

            foreach (int sco in nums)
            {

                if (counter == 0)
                {
                    sb.Append(sco);
                }
                else if (counter >= 1)
                {
                    sb.Append(delimiter.ToString() + sco);
                }
                counter++;
            }

            return sb.ToString();
        }

    }
}

