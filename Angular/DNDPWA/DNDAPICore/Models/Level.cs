using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class Level
    {
        [Key]
        public int Id { get; set; }

        public int CurrentLvl { get; set; }
        public int Experience { get; set; }

        [ForeignKey("Character")]
        public int CharacterId { get; set; }
        public Character Character { get; set; }
    }
}
