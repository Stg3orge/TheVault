using CentisoftREST.DAL;
using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.BLL
{
    public class TaskFacade
    {
        private TaskRepository taskRepository;
        public TaskFacade()
        {
            taskRepository = new TaskRepository();
        }

        public List<Task> LoadAllTasksForProject(int projectId)
        {
            return taskRepository.LoadAllTasksForProject(projectId);
        }

        public List<Task> LoadAllTasksForDeveloper(int developerId)
        {
            return taskRepository.LoadAllTasksForDeveloper(developerId);
        }

        public Task LoadTask(int id)
        {
            return taskRepository.Load(id);
        }

        public Task Save(Task task)
        {
            return taskRepository.Save(task);
        }

        internal void DeleteAll()
        {
            taskRepository.DeleteAll();
        }

        public bool CanDeleteTask(int id)
        {
            //can always delete a task
            return true;
        }

        public void DeleteTask(int id)
        {
            taskRepository.DeleteTask(id);
        }
    }
}