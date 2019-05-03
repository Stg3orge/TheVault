using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class AbilityScore
    {
        public int Id { get; set; }
        public int? CharacterId { get; set; }
        public int? AbilityNameId { get; set; }
        public int Base { get; set; }
        public int EnchantmentBonus { get; set; }
        public int MiscBonus { get; set; }
        public int MiscPenalty { get; set; }

        public virtual AbilityScoreName AbilityName { get; set; }
        public virtual Character Character { get; set; }
    }
}
