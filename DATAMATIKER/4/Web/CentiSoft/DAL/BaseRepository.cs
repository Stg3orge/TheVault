using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentisoftREST.DAL
{
    public class BaseRepository
    {
        protected CentiSoftDbContext dbContext;
        public BaseRepository()
        {
            dbContext = new CentiSoftDbContext();
        }
    }
}