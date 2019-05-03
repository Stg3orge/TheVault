using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class AbilityPrerequisite
    {
        public AbilityPrerequisite()
        {
            FeatAbilityPrerequisite = new HashSet<FeatAbilityPrerequisite>();
        }

        public int Id { get; set; }
        public int? AbilityNameId { get; set; }
        public int Ability { get; set; }

        public virtual AbilityScoreName AbilityName { get; set; }
        public virtual ICollection<FeatAbilityPrerequisite> FeatAbilityPrerequisite { get; set; }
    }
}
