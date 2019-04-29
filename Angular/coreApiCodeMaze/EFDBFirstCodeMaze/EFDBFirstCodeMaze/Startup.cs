using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using EFDBFirstCodeMaze.Models;
using EFDBFirstCodeMaze.Models.DataManager;
using EFDBFirstCodeMaze.Models.DTO;
using EFDBFirstCodeMaze.Models.Repository;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;

namespace EFDBFirstCodeMaze
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddDbContext<bookStoreContext>(opts => opts.UseSqlServer(Configuration["ConnectionString:BooksDB"]));

            services.AddScoped<IDataRepository<Author, AuthorDto>, AuthorDataManager>();
            services.AddScoped<IDataRepository<Book, BookDto>, BookDataManager>();
            services.AddScoped<IDataRepository<Publisher, PublisherDto>, PublisherDataManager>();

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseMvc();
        }
    }
}
