using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Spell
    {
        public Spell()
        {
            ClassSpell = new HashSet<ClassSpell>();
        }

        public int Id { get; set; }
        public string Name { get; set; }
        public int? SchoolId { get; set; }
        public string Components { get; set; }
        public string CastingTime { get; set; }
        public string Range { get; set; }
        public string AreaOrTarget { get; set; }
        public string Duration { get; set; }
        public string SavingThrow { get; set; }
        public string SpellResistance { get; set; }
        public string Description { get; set; }

        public virtual School School { get; set; }
        public virtual ICollection<ClassSpell> ClassSpell { get; set; }
    }
}
