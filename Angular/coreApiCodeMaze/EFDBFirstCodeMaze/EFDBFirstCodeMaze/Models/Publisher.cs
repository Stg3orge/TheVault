using System;
using System.Collections.Generic;

namespace EFDBFirstCodeMaze.Models
{
    public partial class Publisher
    {
        public Publisher()
        {
            Book = new HashSet<Book>();
        }

        public long Id { get; set; }
        public string Name { get; set; }

        public ICollection<Book> Book { get; set; }
    }
}
