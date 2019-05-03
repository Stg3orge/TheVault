using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace CFAuthorBooks.Models
{
    public class Author
    {
        [Key]
        public int Id { get; set; } // PK

        [Column(TypeName = "nvarchar(100)")]
        public string FirstName { get; set; }
        [Column(TypeName = "nvarchar(100)")]
        public string LastName { get; set; }

        // FKs
        ICollection<Book> Books { get; set; }
    }
}
