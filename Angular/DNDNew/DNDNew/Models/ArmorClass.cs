using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class ArmorClass
    {
        public int CharacterId { get; set; }
        public int NaturalArmor { get; set; }
        public int DeflectionMod { get; set; }
        public int MiscMod { get; set; }

        public virtual Character Character { get; set; }
    }
}
