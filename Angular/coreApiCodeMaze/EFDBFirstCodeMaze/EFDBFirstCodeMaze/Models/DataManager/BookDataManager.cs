using EFDBFirstCodeMaze.Models.DTO;
using EFDBFirstCodeMaze.Models.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EFDBFirstCodeMaze.Models.DataManager
{
    public class BookDataManager : IDataRepository<Book, BookDto>
    {

        private readonly bookStoreContext bookStoreContext;

        public BookDataManager(bookStoreContext storeContext)
        {
            this.bookStoreContext = storeContext;
        }

        public void Add(Book entity)
        {
            throw new NotImplementedException();
        }

        public void Delete(Book entity)
        {
            throw new NotImplementedException();
        }

        public Book Get(long id)
        {
            bookStoreContext.ChangeTracker.LazyLoadingEnabled = false;

            var book = bookStoreContext.Book
                .SingleOrDefault(b => b.Id == id);

            if (book == null)
            {
                return null;
            }

            bookStoreContext.Entry(book)
                .Collection(b => b.BookAuthors)
                .Load();

            bookStoreContext.Entry(book)
                .Reference(b => b.Publisher)
                .Load();

            bookStoreContext.Entry(book)
                .Reference(b => b.Category)
                .Load();

            return book;
        }

        public IEnumerable<Book> GetAll()
        {
            throw new NotImplementedException();
        }

        public BookDto GetDto(long id)
        {
            throw new NotImplementedException();
        }

        public void Update(Book entityToUpdate, Book entity)
        {
            throw new NotImplementedException();
        }
    }
}
