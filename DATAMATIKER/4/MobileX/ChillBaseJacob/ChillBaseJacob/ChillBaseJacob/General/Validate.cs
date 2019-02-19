using System;
using System.Collections.Generic;
using System.Text;

namespace ChillBaseJacob.General
{
    public class Validate
    {
        public static int? ConvertToInt(string inputString)
        {
            // convert
            bool isIntOk = int.TryParse(inputString, out int intValue);
            // evaluate and return
            if (isIntOk)
            {
                return intValue;
            }
            else
            {
                return null;
            }
        }
    }
}
