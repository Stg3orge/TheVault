using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class School
    {
        public School()
        {
            Spell = new HashSet<Spell>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<Spell> Spell { get; set; }
    }
}
