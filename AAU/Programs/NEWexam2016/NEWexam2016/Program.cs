/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NEWexam2016.Core;
using NEWexam2016.Core.Stregsystem;
using NEWexam2016.Core.Exceptions;
using NEWexam2016.Core.Log;
using NEWexam2016.Core.Stregsystem.EventHandling;

namespace NEWexam2016
{
    class Program
    {
        static void Main(string[] args)
        {

            IStregsystem stregsystem = new Stregsystem();
            IStregsystemUI ui = new StregsystemCLI(stregsystem);
            StregsystemController sc = new StregsystemController(stregsystem, ui);

            ui.Start();
        }
    }
}
