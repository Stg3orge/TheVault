using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class PlayerGame
    {
        public int PlayerId { get; set; }
        public int GameId { get; set; }

        public virtual Game Game { get; set; }
        public virtual Player Player { get; set; }
    }
}
