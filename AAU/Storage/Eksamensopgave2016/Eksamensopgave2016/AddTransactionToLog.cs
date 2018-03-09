/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/


using System.Collections.Generic;
using System.IO;

namespace Eksamensopgave2016
{
    class AddTransactionToLog // Adds a negative or positive transaction to a log file
    {
        public void WriteTransactionFileToLog(Transaction transactions) // Syntax retrieved from stack overflow
        {
            using (StreamWriter writer = new StreamWriter("../../../TransactionLog.txt", true)) { writer.WriteLine(transactions.ToString()); };
        }
        public int GetNextTransactionId()
        {
            List<Transaction> transactions = new List<Transaction>();
            if (transactions.Count > 0)
            {
                return transactions.Count + 1;
            }
            return 1;
        }
    }
}

