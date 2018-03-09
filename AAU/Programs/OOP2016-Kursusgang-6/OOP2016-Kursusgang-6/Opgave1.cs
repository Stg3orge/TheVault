namespace OOP2016_Kursusgang_6
{
    public class Pair<DICK>
    {
        public DICK First;
        public DICK Second;

        public Pair(DICK First, DICK Second)
        {
            this.First = First;
            this.Second = Second;
        }

        public void Swap()
        {
            DICK tmp = First;
            First = Second;
            Second = tmp;
        }
    }

}
