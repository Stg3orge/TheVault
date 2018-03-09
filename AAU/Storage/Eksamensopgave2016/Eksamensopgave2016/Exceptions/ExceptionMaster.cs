using System;

namespace Eksamensopgave2016.Exceptions
{
    class ExceptionMaster : Exception // This was meant to be central to proper exception handling but used CLI instead for errors
    {
        public ExceptionMaster(string InputString) : base(InputString)
        {

        }
    }
}
