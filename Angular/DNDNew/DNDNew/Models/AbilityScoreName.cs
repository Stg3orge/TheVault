using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class AbilityScoreName
    {
        public AbilityScoreName()
        {
            AbilityPrerequisite = new HashSet<AbilityPrerequisite>();
            AbilityScore = new HashSet<AbilityScore>();
            Skill = new HashSet<Skill>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<AbilityPrerequisite> AbilityPrerequisite { get; set; }
        public virtual ICollection<AbilityScore> AbilityScore { get; set; }
        public virtual ICollection<Skill> Skill { get; set; }
    }
}
