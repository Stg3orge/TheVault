using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace CentisoftREST.DAL
{
    public class TaskRepository : BaseRepository
    {
        public List<Task> LoadAllTasksForDeveloper(int developerId)
        {
            return dbContext.Tasks.Include(x => x.Developer).Where(x => x.Developer.Id == developerId).ToList();
        }

        public List<Task> LoadAllTasksForProject(int projectId)
        {
            return dbContext.Tasks.Include(x => x.Developer).Include(x=>x.Project).Where(x => x.ProjectId == projectId).OrderBy(x=>x.Created).ToList();
        }

        public Task Load(int id)
        {
            return dbContext.Tasks.Include(x => x.Developer).Include(x=>x.Project).Where(x => x.Id == id).FirstOrDefault();
        }

        public void DeleteTask(int id)
        {
            Task task = Load(id);
            if(task != null)
            {
                dbContext.Tasks.Remove(task);
            }
            dbContext.SaveChanges();
        }

        internal void DeleteAll()
        {
            dbContext.Tasks.RemoveRange(dbContext.Tasks);
            dbContext.SaveChanges();
        }

        public Task Save(Task task)
        {
            if (task.Id > 0)
            {
                Task existingTask = Load(task.Id);
                existingTask.Description = task.Description;
                existingTask.Duration = task.Duration;
                existingTask.Name = task.Name;
            }
            else
            {
                dbContext.Tasks.Add(task);
                dbContext.SaveChanges();
            }
            dbContext.SaveChanges();
            return task;
        }
    }
}