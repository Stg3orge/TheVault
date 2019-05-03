using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DNDAPICore.Models
{
    public class DNDContext : DbContext
    {
        public DNDContext(DbContextOptions<DNDContext> options):base(options)
        {

        }
    }
}
