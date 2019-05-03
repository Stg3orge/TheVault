using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Potion
    {
        public int ItemId { get; set; }
        public string Effect { get; set; }

        public virtual Item Item { get; set; }
    }
}
