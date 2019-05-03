using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Player
    {
        public Player()
        {
            Character = new HashSet<Character>();
            Game = new HashSet<Game>();
            PlayerGame = new HashSet<PlayerGame>();
        }

        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Name { get; set; }

        public virtual ICollection<Character> Character { get; set; }
        public virtual ICollection<Game> Game { get; set; }
        public virtual ICollection<PlayerGame> PlayerGame { get; set; }
    }
}
