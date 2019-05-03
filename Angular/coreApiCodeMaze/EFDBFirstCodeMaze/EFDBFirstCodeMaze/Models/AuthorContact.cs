using System;
using System.Collections.Generic;

namespace EFDBFirstCodeMaze.Models
{
    public partial class AuthorContact
    {
        public long AuthorId { get; set; }
        public string ContactNumber { get; set; }
        public string Address { get; set; }

        public Author Author { get; set; }
    }
}
