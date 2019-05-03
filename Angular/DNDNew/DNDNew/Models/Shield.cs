using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Shield
    {
        public int ItemId { get; set; }
        public int AttackBonus { get; set; }
        public string Damage { get; set; }
        public string Critical { get; set; }
        public string DamageType { get; set; }
        public string ProficiencyType { get; set; }
        public string HandType { get; set; }

        public virtual Armor Item { get; set; }
    }
}
