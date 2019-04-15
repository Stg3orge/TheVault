using CentisoftREST.DAL;
using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.BLL
{
    public class ProjectFacade
    {
        private ProjectRepository projectRepository;
        public ProjectFacade()
        {
            projectRepository = new ProjectRepository();
        }

        public List<Project> LoadAllProjects(int customerId)
        {
            return projectRepository.LoadAllProjects(customerId);
        }

        public Project LoadProject(int id)
        {
            return projectRepository.LoadShallowProject(id);
        }

        public Project SaveProject(Project project)
        {
            return projectRepository.Save(project);
        }

        public bool CanDeleteProject(int id)
        {
            //can not delete a project if it has tasks
            Project p = projectRepository.LoadProject(id);
            return p.Tasks.Count() <= 0;
        }

        internal void DeleteAll()
        {
            projectRepository.DeleteAll();
        }

        public void DeleteProject(int id)
        {
            projectRepository.Delete(id);
        }
    }
}