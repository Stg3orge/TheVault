using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class CharacterBattle
    {
        public int BattleId { get; set; }
        public int CharacterId { get; set; }
        public int? Initiative { get; set; }
        public bool? Active { get; set; }

        public virtual Battle Battle { get; set; }
        public virtual Character Character { get; set; }
    }
}
