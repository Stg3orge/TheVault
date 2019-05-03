using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Armor
    {
        public int ItemId { get; set; }
        public int? MaxDex { get; set; }
        public decimal Weight { get; set; }

        public virtual Item Item { get; set; }
        public virtual Shield Shield { get; set; }
    }
}
