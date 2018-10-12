using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Web;

namespace SlowWeb
{
    /// <summary>
    /// Summary description for SlowMissing
    /// </summary>
    public class SlowMissing : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            Thread.Sleep(2000);
            context.Response.StatusCode = 404;
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}