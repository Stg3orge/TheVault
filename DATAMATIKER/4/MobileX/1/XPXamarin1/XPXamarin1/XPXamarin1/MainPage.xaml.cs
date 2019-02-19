using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using XPXamarin1.Model;

namespace XPXamarin1
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        public void btnInputDickbuttClicedHandler(object sender, EventArgs e)
        {
            string fieldedName = "";

            fieldedName = this.inPersonDick.Text;

            Dickbutt dickbutt = new Dickbutt();

            if(fieldedName != "")
            {
                dickbutt.Name = fieldedName;
                DisplayAlert("Input", "Dickbutt name: " + fieldedName, "OK");
            }
            else
            {
                DisplayAlert("Error Retard", "No Dickbutt in field", "Cancel");
            }
        }
    }
}
