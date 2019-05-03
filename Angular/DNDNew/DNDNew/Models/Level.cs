using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Level
    {
        public int CharacterId { get; set; }
        public int Level1 { get; set; }
        public int Experience { get; set; }

        public virtual Character Character { get; set; }
    }
}
