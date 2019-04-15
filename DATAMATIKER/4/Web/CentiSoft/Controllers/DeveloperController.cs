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
    public class DeveloperController : ApiController
    {
        private DeveloperFacade developerFacade;
        public DeveloperController()
        {
            developerFacade = new DeveloperFacade();
        }

        [HttpGet]
        [Route("developers")]
        public List<Developer> GetAllDevelopers()
        {
            return developerFacade.LoadAllDevelopers();
        }

        [HttpGet]
        [Route("developers/{id}")]
        public Developer GetDeveloper(int id)
        {            
            return developerFacade.LoadDeveloper(id);
        }

        [HttpPost]
        [Route("developers")]
        public Developer SaveDeveloper([FromBody]Developer developer)
        {
                    
            Developer result = developerFacade.SaveDeveloper(developer);
            return result;
        }

        [HttpPut]
        [Route("developers/{id}")]
        public Developer UpdateDeveloper([FromBody]Developer developer)
        {

            Developer result = developerFacade.SaveDeveloper(developer);
            return result;
        }

        [HttpDelete]
        [Route("developers/{id}")]
        public HttpResponseMessage DeleteDeveloper(int id)
        {
            if(developerFacade.CanDeleteDeveloper(id))
            {
                developerFacade.DeleteDeveloper(id);
                return Request.CreateResponse(HttpStatusCode.OK);
            }
            return Request.CreateResponse(HttpStatusCode.Forbidden, "Cannot delete developer, there are other objects referencing this");
        }
    }
}
