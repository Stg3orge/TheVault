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
    class InsufficientCreditsException : Exception
    {                                                                     // base er message ie en string
        public InsufficientCreditsException(User user, Product product) : base($"{user.Username} not allowed to purchase {product.Name}, insufficient funds.")
        {

        }
    }
}
