using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CFAuthorBooks.Models
{
    public class AuthorBooksContext : DbContext
    {
        public AuthorBooksContext(DbContextOptions<AuthorBooksContext> options):base(options)
        {

        }

        public DbSet<Author> Authors { get; set; }
        public DbSet<Book> Books { get; set; }
    }
}
