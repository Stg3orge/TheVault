using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http.Controllers;
using System.Web.Http.Filters;

namespace CentisoftREST.ActionFilters
{
    public class ValidateCentisoftTokenAttribute : ActionFilterAttribute
    {
        public ValidateCentisoftTokenAttribute()
        {

        }

        public override void OnActionExecuting(HttpActionContext actionContext)
        {
            IEnumerable<string> authenticatedTokens = new string[]{ "VerySecretToken1"};

            actionContext.Request.Headers.TryGetValues("centisoft_token", out var headers);

            string token = headers?.FirstOrDefault();

            if (string.IsNullOrEmpty(token))
            {
                var response = new HttpResponseMessage
                {
                    StatusCode = HttpStatusCode.BadRequest,
                    ReasonPhrase = "Bad Request",
                    Content = new StringContent("The header centisoft_token was missing")
                };

                actionContext.Response = response;
            }
            else if (!authenticatedTokens.Contains(token))
            {
                var response = new HttpResponseMessage
                {
                    StatusCode = HttpStatusCode.Unauthorized,
                    ReasonPhrase = "Unauthorized",
                    Content = new StringContent("The token could not be validated. You could try with 'VerySecretToken1' (https://bit.ly/2WoAmYh) ")
                };

                actionContext.Response = response;
            }
        }

    }
}