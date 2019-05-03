using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Skill
    {
        public int Id { get; set; }
        public int? CharacterId { get; set; }
        public int? SkillNameId { get; set; }
        public int SkillpointAmount { get; set; }
        public int MiscMod { get; set; }
        public int? AsNameId { get; set; }

        public virtual AbilityScoreName AsName { get; set; }
        public virtual Character Character { get; set; }
        public virtual SkillName SkillName { get; set; }
    }
}
