using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class Player
    {
        [Key]
        public int Id { get; set; }

        [Column("nvarchar(50)")]
        public string Username { get; set; }
        [Column("nvarchar(50)")]
        public string Password { get; set; }
        [Column("nvarchar(50)")]
        public string Name { get; set; }
    }
}
