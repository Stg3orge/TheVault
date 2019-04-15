using System;
using System.Collections.Generic;
using System.Text;

namespace ChillBaseJacob.Meteorology
{
        public class WindChillFactor
        {
            public TemperatureScale.Scale TempScale { set; get; }
            public WindSpeedUnit.Unit WindUnit { set; get; }
            public int TempDegrees { set; get; }
            public int WindSpeed { set; get; }
            private double calculatedChillFactorTemp = 0;
            public double ChillFactorTemperature
            {
                get
                {
                    return calculatedChillFactorTemp;
                }
            }

            public WindChillFactor(TemperatureScale.Scale inScale, WindSpeedUnit.Unit inUnit, int inDegrees, int inWindSpeed)
            {
                TempScale = inScale;
                WindUnit = inUnit;
                TempDegrees = inDegrees;
                WindSpeed = inWindSpeed;
            }

            /*
             * Uses formula from https://www.weather.gov/media/epz/wxcalc/windChill.pdf
             * To use the formula temperature (T) must be in Fahrenheit and wind speed (Wind_sfc) in Mph.
            */
            public void CalulateChillFactorTemperature()
            {

                // Ensure data ok for calculation
                double T = TempDegrees;
                if (TempScale == TemperatureScale.Scale.Celsius)
                {
                    T = ConvertCelsiusToFahrenheit(TempDegrees);
                }
                double Wind_sfc = WindSpeed;
                if (WindUnit == WindSpeedUnit.Unit.MeterPerSecond)
                {
                    Wind_sfc = ConverMeterPerSecondToMilesPerHour(WindSpeed);
                }

                // Calculate the formula part and finally combine them
                double powerConstant = 0.16;
                double part1 = 35.74;
                double part2 = 0.6215 * T;
                double part3 = Math.Pow(Wind_sfc, powerConstant) * 35.75;
                double part4 = Math.Pow(Wind_sfc, powerConstant) * T * 0.4275;
                double chillDegreeResult = part1 + part2 + part4 - part3;

                if (TempScale == TemperatureScale.Scale.Celsius)
                {
                    chillDegreeResult = ConvertFahrenheitToCelsius(chillDegreeResult);
                }

                calculatedChillFactorTemp = Math.Round(chillDegreeResult, 1);
            }


            private double ConvertCelsiusToFahrenheit(int degreesInC)
            {
                return (degreesInC * 1.8 + 32);
            }

            private double ConvertFahrenheitToCelsius(double degreesInF)
            {
                return (degreesInF - 32) / 1.8;
            }

            private double ConverMilesPerHourToMeterPerSecond(int windInMilesPerHour)
            {
                return windInMilesPerHour * 0.44704;
            }

            private double ConverMeterPerSecondToMilesPerHour(int windInMeterPerSecond)
            {
                return windInMeterPerSecond / 0.44704;
            }

        }
    }

