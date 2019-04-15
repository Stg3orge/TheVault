using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.DAL
{
    public class ClientRepository : BaseRepository
    {
        public Client LoadClient(int id)
        {
            return dbContext.Clients.FirstOrDefault(x => x.Id == id);
        }

        public Client LoadClient(string token)
        {
            return dbContext.Clients.FirstOrDefault(x => x.Token == token);
        }

        public Client Save(Client client)
        {
            if(client.Id > 0)
            {
                //update
                Client existingClient = LoadClient(client.Id);
                existingClient.Name = client.Name;
                existingClient.Token = client.Token;
            }
            else
            {
                dbContext.Clients.Add(client);
            }
            dbContext.SaveChanges();
            return client;
        }

        internal void DeleteAll()
        {
            dbContext.Clients.RemoveRange(dbContext.Clients);
            dbContext.SaveChanges();
        }
    }
}