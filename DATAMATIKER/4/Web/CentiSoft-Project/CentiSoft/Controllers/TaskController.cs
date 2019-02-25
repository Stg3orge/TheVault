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
    /// <summary>
    /// This class handles everything about tasks in the task system
    /// </summary>
    public class TaskController : ApiController
    {
        private TaskFacade taskFacade;

        /// <summary>
        /// Creates a new Task Controller instance
        /// </summary>
        public TaskController()
        {
            taskFacade = new TaskFacade();
        }

        /// <summary>
        /// Get all tasks for a specific project
        /// </summary>
        /// <param name="projectId">The id of the project from which to get the tasks</param>
        /// <returns></returns>
        [HttpGet]
        [Route("projects/{projectId}/tasks")]
        public List<Task> GetAllTasks(int projectId)
        {
            return taskFacade.LoadAllTasksForProject(projectId);
        }

        /// <summary>
        /// Get a single task from a specific project.
        /// </summary>
        /// <param name="id">The id of the task to get</param>
        /// <param name="projectId">The id of the project to get the task from</param>
        /// <returns></returns>
        [HttpGet]
        [Route("projects/{projectId}/tasks/{id}")]
        public Task LoadTask(int id)
        {
            return taskFacade.LoadTask(id);
        }

        [HttpPost, HttpPut]
        [Route("projects/{projectId}/tasks")]
        public Task SaveTask([FromBody]Task task)
        {
            return taskFacade.Save(task);
        }

        [HttpDelete]
        [Route("projects/{projectId}/tasks")]
        public HttpResponseMessage DeleteTask(int id)
        {
            if (taskFacade.CanDeleteTask(id))
            {
                taskFacade.DeleteTask(id);
                return Request.CreateResponse(HttpStatusCode.OK);
            }
            return Request.CreateResponse(HttpStatusCode.Forbidden);
        }
    }
}
