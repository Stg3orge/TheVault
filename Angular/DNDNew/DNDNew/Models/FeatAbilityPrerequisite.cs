using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class FeatAbilityPrerequisite
    {
        public int FeatId { get; set; }
        public int ApId { get; set; }

        public virtual AbilityPrerequisite Ap { get; set; }
        public virtual Feat Feat { get; set; }
    }
}
