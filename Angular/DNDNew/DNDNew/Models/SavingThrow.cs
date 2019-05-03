using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class SavingThrow
    {
        public int Id { get; set; }
        public int? CharacterId { get; set; }
        public int? SavingThrowNameId { get; set; }
        public int MagicMod { get; set; }
        public int MiscMod { get; set; }
        public int TempMod { get; set; }
        public int ConditionalMod { get; set; }

        public virtual Character Character { get; set; }
        public virtual SavingThrowName SavingThrowName { get; set; }
    }
}
