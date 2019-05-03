using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Scroll
    {
        public int ItemId { get; set; }
        public string ClassType { get; set; }
        public string Size { get; set; }
        public int NumberOfSpells { get; set; }

        public virtual Item Item { get; set; }
    }
}
