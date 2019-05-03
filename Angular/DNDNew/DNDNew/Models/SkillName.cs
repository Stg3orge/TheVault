using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class SkillName
    {
        public SkillName()
        {
            Skill = new HashSet<Skill>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<Skill> Skill { get; set; }
    }
}
