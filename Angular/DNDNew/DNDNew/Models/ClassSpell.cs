using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class ClassSpell
    {
        public int ClassId { get; set; }
        public int SpellId { get; set; }
        public int SpellLevel { get; set; }

        public virtual Class Class { get; set; }
        public virtual Spell Spell { get; set; }
    }
}
