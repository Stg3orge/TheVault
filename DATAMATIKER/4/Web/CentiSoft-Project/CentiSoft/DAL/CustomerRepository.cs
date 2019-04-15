using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.DAL
{
    public class CustomerRepository : BaseRepository
    {
        public List<Customer> LoadAll()
        {
            //return dbContext.Customers.
            return dbContext.Customers.ToList();
        }

        internal void DeleteAll()
        {
            dbContext.Customers.RemoveRange(dbContext.Customers);
            dbContext.SaveChanges();
        }

        public Customer Save(Customer customer)
        {
            if (customer.Id > 0)
            {
                //update
                Customer existingCustomer = LoadCustomer(customer.Id);
                if (existingCustomer != null)
                {
                    existingCustomer.Address = customer.Address;
                    existingCustomer.Address2 = customer.Address2;
                    existingCustomer.City = customer.City;
                    existingCustomer.Country = customer.Country;
                    existingCustomer.Email = customer.Email;
                    existingCustomer.Name = customer.Name;
                    existingCustomer.Phone = customer.Phone;
                    existingCustomer.Zip = customer.Zip;
                }
                else
                {
                    //didnt find the existing user, as an update. Guess its an insert
                    dbContext.Customers.Add(customer);
                }
            }
            else
            {
                dbContext.Customers.Add(customer);
            }
            dbContext.SaveChanges();
            return customer;
        }

        internal void DeleteCustomer(int id)
        {
            Customer customer = LoadCustomer(id);
            if (customer != null)
            {
                dbContext.Customers.Remove(customer);
                dbContext.SaveChanges();
            }
        }

        public Customer LoadCustomer(int id)
        {
            return dbContext.Customers.FirstOrDefault(x => x.Id == id);
        }
    }
}