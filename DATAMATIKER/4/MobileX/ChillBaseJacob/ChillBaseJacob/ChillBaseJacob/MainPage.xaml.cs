using ChillBaseJacob.General;
using ChillBaseJacob.Meteorology;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace ChillBaseJacob
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        void ClickedConvert(object sender, System.EventArgs e)
        {
            bool allOk = true;
            string errorText = "";

            // Get temperature scale
            TemperatureScale.Scale tempScaleToUse = TemperatureScale.Scale.None;
            object foundScaleObj = tempScale.SelectedItem;

            if (foundScaleObj != null)
            {
                string foundScale = foundScaleObj.ToString();
                tempScaleToUse = TemperatureScale.GetScale(foundScale);
            }
            else
            {
                allOk = false;
                errorText = "Please choose temperature scale!";
            }

            // Get degrees
            int? degrees = Convert.ToInt32(inputDegrees.Text);
            if (allOk)
            {
                degrees = Validate.ConvertToInt(inputDegrees.Text);
                if (degrees == null)
                {
                    allOk = false;
                    errorText = "Please input temperature degrees as an integer!";
                }
            }

            // Get wind unit
            WindSpeedUnit.Unit windUnitToUse = WindSpeedUnit.Unit.None;
            object foundUnitObj = windUnit.SelectedItem;
            string foundUnit = null;
            if (foundUnitObj != null)
            {
                foundUnit = foundUnitObj.ToString();
                windUnitToUse = WindSpeedUnit.GetUnit(foundUnit);
            }
            else
            {
                allOk = false;
                errorText = "Please choose wind speed unit!";
            }

            // Get wind speed
            int? speed = Convert.ToInt32(inputSpeed.Text);
            // Get speed


            // Process input data and show result
            if (allOk)
            {
                WindChillFactor calculator = new WindChillFactor(tempScaleToUse, windUnitToUse, (int)degrees, (int)speed);
                calculator.CalulateChillFactorTemperature();
                result1.Text = inputDegrees.Text + " degrees " + tempScale.SelectedItem.ToString() +
                    " and wind speed " + inputSpeed.Text + " " + windUnit.SelectedItem.ToString();
                result2.Text = $"Feels like {calculator.ChillFactorTemperature} degrees {tempScale.SelectedItem.ToString()}.";
                //errorMessage.Text = "";
            }
            else
            {
                DisplayAlert("Missing Information", errorText, "Cancel");
            }
        }
    }
}

