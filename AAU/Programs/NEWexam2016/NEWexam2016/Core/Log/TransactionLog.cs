/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace NEWexam2016.Core.Log
{
    class TransactionLog
    {
        public void WriteTransactionLog(Transaction transaction)
        {
            // Transaction ToString() bliver skrevet til en TransactionLog.txt
            using (StreamWriter writer = new StreamWriter("../../../TransactionLog.txt", true)) { writer.WriteLine(transaction.ToString()); };
        }
        public int NextTransactionID()
        {
            List<Transaction> transactions = new List<Transaction>();

            if (transactions.Count > 0)
            {
                return transactions.Count + 1; // En liste der ikke kan have 0 transactions
            }
            else
            {
                return 1;
            }
        }
    }
}
