using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseJavaToCsharpChallenge
{
    class Employee : IPerson
    {
        private static string nameString = "JACOB";
        private List<string> favouriteWords = new List<string>();

        public Employee(string e)
        {
            nameString = e;
        }

        public void addFavoriteWord(string w)
        {
            favouriteWords.Add(w);
        }

        public string getEmployeeName()
        {
            return nameString;
        }

        public void printAllWords()
        {
            for (int i = 0; i < favouriteWords.Count; i++)
            {
                Console.WriteLine(favouriteWords[i]);
            }
        }

        public void setEmployeeName(string n)
        {
            nameString = n;
        }
    }
}
