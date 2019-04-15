/*
 * Modified example from on Pluralsight cource
 * XAML for Xamarin.Forms by Jesse Liberty
 */

using System;
using Xamarin.Forms;

namespace BasicExample
{
	public partial class MainPage : ContentPage
	{
		public MainPage()
		{
			InitializeComponent();

            btn3.Style = Application.Current.Resources["buttonStyle"] as Style;
        }
	}
}
