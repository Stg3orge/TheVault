using CentisoftREST.BLL;
using CentisoftREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CentisoftREST.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.Title = "Home Page";

            return View();
        }

        public string Seed()
        {
            ClientFacade clientFacade = new ClientFacade();
            CustomerFacade customerFacade = new CustomerFacade();
            DeveloperFacade developerFacade = new DeveloperFacade();
            ProjectFacade projectFacade = new ProjectFacade();
            TaskFacade taskFacade = new TaskFacade();
            //clean all data
            clientFacade.DeleteAll();
            customerFacade.DeleteAll();
            developerFacade.DeleteAll();
            projectFacade.DeleteAll();
            //insert new data
            //client
            Client client = new Client();
            client.Name = "Test Client";
            client.Token = "ABC1234";
            client = clientFacade.SaveClient(client);

            //customer
            Customer customer = new Customer();
            customer.Address = "Sofiendalsvej 60";
            customer.City = "Aalborg";
            customer.Country = "Denmark";
            customer.Email = "info@ucn.dk";
            customer.Name = "UCN";
            customer.Phone = "12345678";
            customer.Zip = "9200";
            customer.ClientId = client.Id;            
            customer = customerFacade.SaveCustomer(customer);

            //developers
            Developer developer = new Developer();
            developer.Email = "luke@skywalker.com";
            developer.Name = "Luke Skywalker";
            developer = developerFacade.SaveDeveloper(developer);

            developer = new Developer();
            developer.Email = "wec@ncc1701.com";
            developer.Name = "Wesley Crusher";
            developer = developerFacade.SaveDeveloper(developer);

            developer = new Developer();
            developer.Email = "jlp@ncc1701.com";
            developer.Name = "Jean-Luc Picard";
            developer = developerFacade.SaveDeveloper(developer);

            //project
            Project project = new Project();
            project.Name = "Development of new polling system";
            project.DueDate = DateTime.Parse("2018/12/31");
            project.CustomerId = customer.Id;       
            project = projectFacade.SaveProject(project);

            //tasks
            Task task = new Task();
            task.Created = DateTime.Now;
            task.Description = "Working on the new UI design";
            task.DeveloperId = developer.Id;
            task.Duration = 2.5f;
            task.Name = "New UI";
            task.ProjectId = project.Id;
            task.DeveloperId = developer.Id;
            taskFacade.Save(task);

            task.Created = DateTime.Now;
            task.Description = "Building the DAL using Entity Framework Code First";
            task.DeveloperId = developer.Id;
            task.Duration = 6.5f;
            task.Name = "Build DAL";
            task.ProjectId = project.Id;
            task.DeveloperId = developer.Id;
            taskFacade.Save(task);

            return "Done seeding database...";
        }
    }
}
