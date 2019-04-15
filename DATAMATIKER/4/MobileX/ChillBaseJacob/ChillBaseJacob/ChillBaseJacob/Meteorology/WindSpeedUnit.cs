using System;
using System.Collections.Generic;
using System.Text;

namespace ChillBaseJacob.Meteorology
{
    public class WindSpeedUnit
    {
        public enum Unit { None, MeterPerSecond, MilesPerHour };

        public static Unit GetUnit(string unitString)
        {
            Unit foundUnit = Unit.None;

            if (unitString.ToLower().Equals("mph"))
            {
                foundUnit = Unit.MilesPerHour;
            }
            if (unitString.ToLower().Equals("m/s"))
            {
                foundUnit = Unit.MeterPerSecond;
            }

            return foundUnit;
        }
    }
}
