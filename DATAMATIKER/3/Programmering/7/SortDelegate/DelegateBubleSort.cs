using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortDelegate {
    static class DelegateBubleSort {

        static List<int> even = new List<int>();
        static List<int> odd = new List<int>();
        static List<int> ordered = new List<int>();

        // BubleSort with Delegate parameter - code that governs the comparison of two int values
        public static void BubbleSort(int[] items, Func<int, int, bool> del) {
            int i, j, temp;

            if (items != null) {

                for (i = items.Length - 1; i >= 0; i--) {
                    for (j = 1; j <= i; j++) {
                        if (del(items[j - 1], items[j])) {
                            temp = items[j - 1];
                            items[j - 1] = items[j];
                            items[j] = temp;
                        }
                    }
                }
            }// ends if
        }

        // Sort order - in ascending order
        public static bool GreaterThan(int first, int second) {
            bool isGreater = (first > second);
            return isGreater;
        }

        // Sort order - in ascending alphabetic order
        public static bool AlphabetOrder(int first, int second)
        {
            string input1 = first.ToString();
            string input2 = second.ToString();

            input1 = input1.Substring(0, 1);
            input2 = input2.Substring(0, 1);

            int firstAfter = 0;
            int secondAfter = 0;

            firstAfter = Convert.ToInt32(input1);
            secondAfter = Convert.ToInt32(input2);

            bool alphabetical = (secondAfter < firstAfter);
            return alphabetical;
        }

        

        // Sort order - even values before odd values
        public static bool EvenOddOrder(int first, int second)
        {
            //ordered.AddRange(even);
            //ordered.AddRange(odd);

            bool val = false;

            if(IsEven(first) && IsEven(second))
            {
                val = (first > second);
            }
            else if (IsOdd(first) && IsOdd(second))
            {
                val = (first > second);
            }
            else if(IsEven(first) && IsOdd(second))
            {
                return val;
            }
            else if(IsOdd(first) && IsEven(second))
            {
                return val;
            }

            return val;
        }

        public static bool IsEven(int value)
        {
            return value % 2 == 0;
        }

        public static bool IsOdd(int value)
        {
            return value % 2 != 0;
        }
        // Sort order - even values in ascending order, then odd values in ascending order


    }
}
