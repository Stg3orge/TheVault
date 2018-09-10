using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public class Juice : Consumable
    {
        int restore;

        public Juice(string title) : base(title)
        {
            restore = 20;
        }

        public override void Consume(Player player)
        {
            Console.WriteLine("I drank something rancid!");
        }
    }
}
