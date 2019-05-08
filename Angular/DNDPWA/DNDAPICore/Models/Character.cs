using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class Character
    {
        [Key]
        public int Id { get; set; }

        public Hitpoints Hitpoints { get; set; }
    }
}
