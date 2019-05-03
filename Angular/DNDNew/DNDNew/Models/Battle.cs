using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Battle
    {
        public Battle()
        {
            CharacterBattle = new HashSet<CharacterBattle>();
        }

        public int Id { get; set; }
        public bool Activebattle { get; set; }
        public int? GameId { get; set; }

        public virtual Game Game { get; set; }
        public virtual Notification Notification { get; set; }
        public virtual ICollection<CharacterBattle> CharacterBattle { get; set; }
    }
}
