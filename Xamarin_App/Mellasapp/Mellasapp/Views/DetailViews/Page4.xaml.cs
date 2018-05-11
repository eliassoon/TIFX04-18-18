using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;


namespace Mellasapp
{
    public partial class Page4 : ContentPage
    {
        public Page4()

        {
            InitializeComponent();

        }

        void Handle_Clicked(object sender, System.EventArgs e)
        {
            DisplayAlert("Sparat", "Nu är din data sparad", "Stäng");
        }
    }
}
