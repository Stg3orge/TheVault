using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using EFDBFirstCodeMaze.Models.DTO;
using EFDBFirstCodeMaze.Models.Repository;
using EFDBFirstCodeMaze.Models;
using Microsoft.EntityFrameworkCore;

namespace EFDBFirstCodeMaze.Models.DataManager
{
    public class AuthorDataManager : IDataRepository<Author, AuthorDto>
    {
        private readonly bookStoreContext bookStoreContext;

        public AuthorDataManager(bookStoreContext storeContext)
        {
            bookStoreContext = storeContext;
        }

        public void Add(Author entity)
        {
            bookStoreContext.Author.Add(entity);
            bookStoreContext.SaveChanges();
        }

        public void Delete(Author entity)
        {
            throw new NotImplementedException();
        }

        public Author Get(long id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Author> GetAll()
        {
            return bookStoreContext.Author
                  .Include(author => author.AuthorContact)
                  .ToList();
        }

        public AuthorDto GetDto(long id)
        {
            //Set lazy loading til true, BookStoreContext er base false
            bookStoreContext.ChangeTracker.LazyLoadingEnabled = true;

            using (var context = new bookStoreContext())
            {
                var author = context.Author
                       .SingleOrDefault(b => b.Id == id);
                return AuthorDtoMapper.MapToDto(author);
            }
        }

        public void Update(Author entityToUpdate, Author entity)
        {
            throw new NotImplementedException();
            //bookStoreContext.Update(entityToUpdate, entity);
        }
    }
}
