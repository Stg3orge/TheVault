using System;
using System.Windows;
using System.Windows.Controls;
using WindChillBase.General;
using WindChillBase.Meteorology;

namespace WindChillBase {
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window {
        public MainWindow() {
            InitializeComponent();
        }

        void ClickedConvert(object sender, System.EventArgs e) {
            bool allOk = true;
            string errorText = "";

            // Get temperature scale
            TemperatureScale.Scale tempScaleToUse = TemperatureScale.Scale.None;
            var foundScaleItem = tempScale.SelectedItem as ComboBoxItem;
            if (foundScaleItem != null) {
                string foundScale = foundScaleItem.Content.ToString();
                tempScaleToUse = TemperatureScale.GetScale(foundScale);
            } else {
                allOk = false;
                errorText = "Please choose temperature scale!";
            }

            // Get degrees
            int? degrees = 0;
            if (allOk) {
                degrees = Validate.ConvertToInt(inputDegrees.Text);
                if (degrees == null) {
                    allOk = false;
                    errorText = "Please input temperature degrees as an integer!";
                }
            }

            // Get wind unit
            string foundUnit = null;

            // Get wind speed
            int? speed = 0;

            // Process input data and show result
            if (allOk) {
                WindChillFactor calculator = new WindChillFactor(tempScaleToUse, WindSpeedUnit.Unit.None, (int)degrees, (int)speed);
                calculator.CalulateChillFactorTemperature();
                result1.Content = "Hi";
                result2.Content = "Hi";
                //errorMessage.Content = "";
            } 
        }

    }
}
