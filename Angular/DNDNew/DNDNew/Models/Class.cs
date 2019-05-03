using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Class
    {
        public Class()
        {
            CharacterClass = new HashSet<CharacterClass>();
            ClassFeat = new HashSet<ClassFeat>();
            ClassSpell = new HashSet<ClassSpell>();
            Feat = new HashSet<Feat>();
        }

        public int Id { get; set; }
        public string Name { get; set; }
        public bool Spellcaster { get; set; }

        public virtual ICollection<CharacterClass> CharacterClass { get; set; }
        public virtual ICollection<ClassFeat> ClassFeat { get; set; }
        public virtual ICollection<ClassSpell> ClassSpell { get; set; }
        public virtual ICollection<Feat> Feat { get; set; }
    }
}
