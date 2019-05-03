using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class SavingThrowName
    {
        public SavingThrowName()
        {
            SavingThrow = new HashSet<SavingThrow>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<SavingThrow> SavingThrow { get; set; }
    }
}
