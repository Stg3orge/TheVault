using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CFAuthorBooks.Models
{
    public class Book
    {
        [Key]
        public int Id { get; set; }
        
        [Column(TypeName = "nvarchar(50)")]
        public string Title { get; set; }
        [Column(TypeName = "nvarchar(200)")]
        public string Description { get; set; }

        [ForeignKey("Author")]
        public int AuthorRefId { get; set; }
        public Author Author { get; set; }
    }
}
