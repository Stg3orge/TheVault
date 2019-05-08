﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class Hitpoints
    {
        [Key]
        public int Id { get; set; }
        public int CurrentHP { get; set; }
        public int MaxHP { get; set; }
        public int TempHP { get; set; }

        [ForeignKey("Character")]
        public int CharacterId { get; set; }
        public Character Character { get; set; }
    }
}
