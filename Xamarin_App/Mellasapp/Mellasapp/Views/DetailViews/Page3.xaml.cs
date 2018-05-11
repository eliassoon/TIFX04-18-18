using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;


namespace Mellasapp
{
    public partial class Page3 : ContentPage
    {
        public Page3()
        {
            InitializeComponent();
        }
        async void OnAlertYesNoClicked(object sender, EventArgs e)
        {
            var answer = await DisplayAlert("Start messuring", "Would you like to start messuring?", "Yes", "No");
            Debug.WriteLine("Answer: " + answer);
      
        }
    }
}