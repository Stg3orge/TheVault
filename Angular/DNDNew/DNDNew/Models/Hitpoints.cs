using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Hitpoints
    {
        public int CharacterId { get; set; }
        public int Current { get; set; }
        public int Max { get; set; }
        public int Temp { get; set; }

        public Character Character { get; set; }
    }
}
