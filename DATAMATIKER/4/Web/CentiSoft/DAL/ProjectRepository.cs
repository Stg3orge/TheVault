using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Web;

namespace CentisoftREST.DAL
{
    public class ProjectRepository : BaseRepository
    {
        public List<Project> LoadAllProjects(int customerId)
        {
            return dbContext.Projects.Where(x=>x.Customer.Id == customerId).ToList();
        }

        public Project LoadShallowProject(int id)
        {
            return dbContext.Projects.FirstOrDefault(x => x.Id == id);
        }

        public Project LoadProject(int id)
        {
            return dbContext.Projects.Include(x=>x.Customer).Include(x=>x.Tasks).FirstOrDefault(x => x.Id == id);
        }

        public Project Save(Project project)
        {
            Project result = project;
            if(project.Id > 0)
            {
                //its an update
                Project existingProject = LoadProject(project.Id);
                if (existingProject != null)
                {
                    existingProject.DueDate = project.DueDate;
                    existingProject.Name = project.Name;
                    result = existingProject;
                }
                else
                {
                    //we done have it, add it
                    dbContext.Projects.Add(project);
                }
            }
            else
            {
                dbContext.Projects.Add(project);
            }
            dbContext.SaveChanges();
            return result;
        }

        internal void DeleteAll()
        {
            dbContext.Projects.RemoveRange(dbContext.Projects);
            dbContext.SaveChanges();
        }

        public void Delete(int id)
        {
            Project project = LoadProject(id);
            if (project != null)
            {
                dbContext.Projects.Remove(project);
                dbContext.SaveChanges();
            }
        }
    }
}