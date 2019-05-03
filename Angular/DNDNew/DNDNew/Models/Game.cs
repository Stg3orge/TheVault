using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Game
    {
        public Game()
        {
            Battle = new HashSet<Battle>();
            Character = new HashSet<Character>();
            PlayerGame = new HashSet<PlayerGame>();
        }

        public int Id { get; set; }
        public int? DungeonMasterId { get; set; }

        public virtual Player DungeonMaster { get; set; }
        public virtual ICollection<Battle> Battle { get; set; }
        public virtual ICollection<Character> Character { get; set; }
        public virtual ICollection<PlayerGame> PlayerGame { get; set; }
    }
}
