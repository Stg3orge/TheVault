using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class Game
    {
        [Key]
        public int Id { get; set; }

        [ForeignKey("DungeonMaster")]
        public int DungeonMasterId { get; set; }

        public Player DungeonMaster { get; set; }
    }
}
