using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class BonusAttackPrerequisite
    {
        public BonusAttackPrerequisite()
        {
            FeatBonusAttackPrerequisite = new HashSet<FeatBonusAttackPrerequisite>();
        }

        public int Id { get; set; }
        public int Attack { get; set; }

        public virtual ICollection<FeatBonusAttackPrerequisite> FeatBonusAttackPrerequisite { get; set; }
    }
}
