using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class CharacterFeat
    {
        public int CharacterId { get; set; }
        public int FeatId { get; set; }

        public virtual Character Character { get; set; }
        public virtual Feat Feat { get; set; }
    }
}
