using System;
using System.Collections.Generic;

namespace EFDBFirstCodeMaze.Models
{
    public partial class Book
    {
        public Book()
        {
            BookAuthors = new HashSet<BookAuthors>();
        }

        public long Id { get; set; }
        public string Title { get; set; }
        public long CategoryId { get; set; }
        public long PublisherId { get; set; }

        public BookCategory Category { get; set; }
        public Publisher Publisher { get; set; }
        public ICollection<BookAuthors> BookAuthors { get; set; }
    }
}
