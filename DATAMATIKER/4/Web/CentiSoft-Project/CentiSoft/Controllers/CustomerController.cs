using CentisoftREST.ActionFilters;
using CentisoftREST.BLL;
using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace CentisoftREST.Controllers
{
    [RoutePrefix("api")]
    [ValidateCentisoftToken]
    public class CustomerController : ApiController
    {
        private CustomerFacade customerFacade;
        public CustomerController()
        {
            customerFacade = new CustomerFacade();
        }

        [HttpGet]
        [Route("customers")]
        public List<Customer> LoadAllCustomers()
        {
            return customerFacade.LoadAllCustomers();
        }

        [HttpGet]
        [Route("customers/{id}")]
        public Customer LoadCustomer(int id)
        {
            return customerFacade.LoadCustomer(id);
        }

        [HttpPost, HttpPut]
        [Route("customers/{id}")]
        public Customer SaveCustomer(int id, [FromBody]Customer customer)
        {
            customer.ClientId = 0;
            return customerFacade.SaveCustomer(customer);
        }

        [HttpDelete]
        [Route("customers/{id}")]
        public HttpResponseMessage DeleteCustomer(int id)
        {
            if (customerFacade.CanDeleteCustomer(id))
            {
                customerFacade.DeleteCustomer(id);
                return Request.CreateResponse(HttpStatusCode.OK);
            }
            return Request.CreateResponse(HttpStatusCode.Forbidden, "Cannot delete a customer that contains projects");
        }
    }
}
