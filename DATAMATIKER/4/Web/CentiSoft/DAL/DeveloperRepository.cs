using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace CentisoftREST.DAL
{
    public class DeveloperRepository : BaseRepository
    {
        public List<Developer> LoadAllDevelopers()
        {
            return dbContext.Developers.ToList();
        }

        public Developer Load(int id)
        {
            return dbContext.Developers.Where(x => x.Id == id).FirstOrDefault();
        }

        public Developer Save(Developer developer)
        {
            Developer resultDeveloper = developer;
            if (developer.Id > 0)
            {
                //its an update
                Developer existingDeveloper = Load(developer.Id);
                if (existingDeveloper != null)
                {
                    existingDeveloper.Email = developer.Email;
                    existingDeveloper.Name = developer.Name;
                    resultDeveloper = existingDeveloper;
                }
                else
                {
                    //we dont have the developer, create it
                    dbContext.Developers.Add(developer);
                }
            }
            else
            {
                dbContext.Developers.Add(developer);
            }
            dbContext.SaveChanges();
            return resultDeveloper;
        }

        internal void DeleteAll()
        {
            dbContext.Developers.RemoveRange(dbContext.Developers);
            dbContext.SaveChanges();
        }

        /// <summary>
        /// Deletes the developer with the specified id
        /// </summary>
        /// <param name="id">The id of the developer that should be deleted</param>
        public void Delete(int id)
        {
            Developer developer = Load(id);
            if (developer != null)
            {
                dbContext.Developers.Remove(developer);
                dbContext.SaveChanges();
            }
        }
    }
}