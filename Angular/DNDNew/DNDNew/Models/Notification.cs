using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Notification
    {
        public int BattleId { get; set; }
        public string Description { get; set; }
        public int DurationLeft { get; set; }
        public int? CharacterId { get; set; }

        public virtual Battle Battle { get; set; }
        public virtual Character Character { get; set; }
    }
}
