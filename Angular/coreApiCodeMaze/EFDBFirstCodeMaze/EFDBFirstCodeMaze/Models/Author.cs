using System;
using System.Collections.Generic;

namespace EFDBFirstCodeMaze.Models
{
    public partial class Author
    {
        public Author()
        {
            BookAuthors = new HashSet<BookAuthors>();
        }

        public long Id { get; set; }
        public string Name { get; set; }

        public AuthorContact AuthorContact { get; set; }
        public ICollection<BookAuthors> BookAuthors { get; set; }
    }
}
