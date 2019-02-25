using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CentisoftREST.Models;
using CentisoftREST.DAL;

namespace CentisoftREST.BLL
{
    public class ClientFacade
    {
        private ClientRepository clientRepository; 

        public ClientFacade()
        {
            clientRepository = new ClientRepository();
        }

        public Client LoadClient(string token)
        {
            return clientRepository.LoadClient(token);
        }

        public Client SaveClient(Client client)
        {
            return clientRepository.Save(client);
        }

        internal void DeleteAll()
        {
            clientRepository.DeleteAll();
        }
    }
}