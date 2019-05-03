using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class CharacterClass
    {
        public int CharacterId { get; set; }
        public int ClassId { get; set; }

        public virtual Character Character { get; set; }
        public virtual Class Class { get; set; }
    }
}
