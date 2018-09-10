namespace ExerciseJavaToCsharpChallenge
{
    internal interface IPerson
    {
        string getEmployeeName();
        void setEmployeeName(string n);
        void addFavoriteWord(string w);
        void printAllWords();
    }
}