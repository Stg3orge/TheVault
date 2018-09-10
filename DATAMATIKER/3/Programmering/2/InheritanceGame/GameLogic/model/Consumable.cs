using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public abstract class Consumable : Item
    {
        //public string Title { get; set; }

        public Consumable(string title) : base(title)
        {
            Title = title;
        }

        public abstract void Consume(Player player);
    }
}
