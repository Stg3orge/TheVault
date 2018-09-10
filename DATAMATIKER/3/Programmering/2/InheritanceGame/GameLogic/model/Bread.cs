using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public class Bread : Consumable
    {
        int restore;

        public Bread(string title) : base(title)
        {
            restore = 10;
        }

        public override void Consume(Player player)
        {
            Console.WriteLine("I ate bread!");
        }
    }
}
