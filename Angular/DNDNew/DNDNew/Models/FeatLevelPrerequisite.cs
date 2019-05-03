using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class FeatLevelPrerequisite
    {
        public int FeatId { get; set; }
        public int LpId { get; set; }

        public virtual Feat Feat { get; set; }
        public virtual LevelPrerequisite Lp { get; set; }
    }
}
