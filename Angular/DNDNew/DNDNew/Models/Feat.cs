using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Feat
    {
        public Feat()
        {
            CharacterFeat = new HashSet<CharacterFeat>();
            ClassFeat = new HashSet<ClassFeat>();
            FeatAbilityPrerequisite = new HashSet<FeatAbilityPrerequisite>();
            FeatBonusAttackPrerequisite = new HashSet<FeatBonusAttackPrerequisite>();
            FeatLevelPrerequisite = new HashSet<FeatLevelPrerequisite>();
            FeatPrerequisiteFeatCurr = new HashSet<FeatPrerequisite>();
            FeatPrerequisiteFeatReq = new HashSet<FeatPrerequisite>();
        }

        public int Id { get; set; }
        public string Name { get; set; }
        public string Effect { get; set; }
        public int? ClassId { get; set; }

        public virtual Class Class { get; set; }
        public virtual ICollection<CharacterFeat> CharacterFeat { get; set; }
        public virtual ICollection<ClassFeat> ClassFeat { get; set; }
        public virtual ICollection<FeatAbilityPrerequisite> FeatAbilityPrerequisite { get; set; }
        public virtual ICollection<FeatBonusAttackPrerequisite> FeatBonusAttackPrerequisite { get; set; }
        public virtual ICollection<FeatLevelPrerequisite> FeatLevelPrerequisite { get; set; }
        public virtual ICollection<FeatPrerequisite> FeatPrerequisiteFeatCurr { get; set; }
        public virtual ICollection<FeatPrerequisite> FeatPrerequisiteFeatReq { get; set; }
    }
}
