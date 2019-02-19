using CentisoftREST.DAL;
using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.BLL
{
    public class DeveloperFacade
    {
        private DeveloperRepository developerRepository;
        private TaskRepository taskRepository;

        public DeveloperFacade()
        {
            developerRepository = new DeveloperRepository();
            taskRepository = new TaskRepository();
        }

        public List<Developer> LoadAllDevelopers()
        {
            return developerRepository.LoadAllDevelopers();
        }

        public Developer LoadDeveloper(int id)
        {
            return developerRepository.Load(id);
        }

        public Developer SaveDeveloper(Developer developer)
        {
            return developerRepository.Save(developer);
        }

        internal void DeleteAll()
        {
            developerRepository.DeleteAll();
        }

        public bool CanDeleteDeveloper(int id)
        {
            //determine if this developer can be deleted
            //a developer cannot be deleted when/if there is tasks assigned to him
            return true;
            //return taskRepository.LoadAllTasksForDeveloper(id).Count <= 0;
        }

        public void DeleteDeveloper(int id)
        {
            developerRepository.Delete(id);
        }
    }
}