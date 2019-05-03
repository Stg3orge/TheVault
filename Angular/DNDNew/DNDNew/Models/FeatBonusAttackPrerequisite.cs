using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class FeatBonusAttackPrerequisite
    {
        public int FeatId { get; set; }
        public int BapId { get; set; }

        public virtual BonusAttackPrerequisite Bap { get; set; }
        public virtual Feat Feat { get; set; }
    }
}
