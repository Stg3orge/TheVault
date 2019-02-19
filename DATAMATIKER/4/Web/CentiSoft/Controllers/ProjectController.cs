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
    public class ProjectController : ApiController
    {
        private ProjectFacade projectFacade;
        public ProjectController()
        {
            projectFacade = new ProjectFacade();
        }

        [HttpGet]
        [Route("customers/{customerId}/projects")]
        public List<Project> GetProjects(int customerId)
        {
            return projectFacade.LoadAllProjects(customerId);
        }

        [HttpGet]
        [Route("customers/{customerId}/projects/{id}")]
        public Project GetProject(int id)
        {
            return projectFacade.LoadProject(id);
        }

        [HttpPost, HttpPut]
        [Route("customers/{customerId}/projects/{id?}")]
        public Project SaveProject([FromBody]Project project, int customerId, int id = default(int))
        {
            project.Id = id;
            project.CustomerId = customerId;
            return projectFacade.SaveProject(project);
        }

        [HttpDelete]
        [Route("customers/{customerId}/projects/{id}")]
        public HttpResponseMessage DeleteProject(int id)
        {
            if (projectFacade.CanDeleteProject(id))
            {
                projectFacade.DeleteProject(id);
                return Request.CreateResponse(HttpStatusCode.OK);
            }
            return Request.CreateResponse(HttpStatusCode.Forbidden, "Cannot delete a project that contains tasks");
        }
    }
}
