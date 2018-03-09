/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NEWexam2016.Core.Exceptions
{
    class ProductDoesNotExistException : Exception
    {
        public ProductDoesNotExistException() : base("Product does not exist")
        {

        }
    }
}
