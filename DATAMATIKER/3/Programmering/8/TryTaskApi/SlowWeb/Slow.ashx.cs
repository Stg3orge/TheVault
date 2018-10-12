using System.Threading;
using System.Web;

namespace SlowWeb
{
    /// <summary>
    /// A handler that provides a simple textual body...eventually.
    /// </summary>
    public class Slow : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            Thread.Sleep(5000);
            context.Response.ContentType = "text/plain";
            context.Response.Write("Hello World");
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