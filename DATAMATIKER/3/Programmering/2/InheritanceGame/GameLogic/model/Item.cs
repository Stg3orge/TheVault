using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic
{
    public abstract class Item
    {
        public Item(string title)
        {
            Title = title;
        }

        public string Title { get; set; }
    }
}
