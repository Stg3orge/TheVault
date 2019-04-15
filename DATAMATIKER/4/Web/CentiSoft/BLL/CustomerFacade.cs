using CentisoftREST.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CentisoftREST.Models;

namespace CentisoftREST.BLL
{
    public class CustomerFacade
    {
        private CustomerRepository customerRepository;
        private ProjectRepository projectRepository;

        public CustomerFacade()
        {
            customerRepository = new CustomerRepository();
            projectRepository = new ProjectRepository();
        }

        internal void DeleteAll()
        {
            customerRepository.DeleteAll();
        }

        public Customer SaveCustomer(Customer customer)
        {            
            return customerRepository.Save(customer);
        }

        public List<Customer> LoadAllCustomers()
        {
            return customerRepository.LoadAll();
        }

        public Customer LoadCustomer(int id)
        {
            return customerRepository.LoadCustomer(id);
        }

        internal void DeleteCustomer(int id)
        {
            customerRepository.DeleteCustomer(id);
        }

        internal bool CanDeleteCustomer(int id)
        {
            return projectRepository.LoadAllProjects(id).Count <= 0;
        }
    }
}