using EFDBFirstCodeMaze.Models.DTO;
using EFDBFirstCodeMaze.Models.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EFDBFirstCodeMaze.Models.DataManager
{
    public class PublisherDataManager : IDataRepository<Publisher, PublisherDto>
    {
        public void Add(Publisher entity)
        {
            throw new NotImplementedException();
        }

        public void Delete(Publisher entity)
        {
            throw new NotImplementedException();
        }

        public Publisher Get(long id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Publisher> GetAll()
        {
            throw new NotImplementedException();
        }

        public PublisherDto GetDto(long id)
        {
            throw new NotImplementedException();
        }

        public void Update(Publisher entityToUpdate, Publisher entity)
        {
            throw new NotImplementedException();
        }
    }
}
