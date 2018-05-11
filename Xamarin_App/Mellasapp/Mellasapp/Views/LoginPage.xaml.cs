using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Mellasapp.Models;
using Mellasapp.Data;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Mellasapp.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class LoginPage : ContentPage
    {
        public LoginPage()
        {
            InitializeComponent();
            Init();

        }
        void Init()
        {
            BackgroundColor = Constants.BackgroundColor;
            Lbl_Username.TextColor = Constants.BackgroundColor;
            Lbl_Password.TextColor = Constants.BackgroundColor;
            ActivitySpinner.IsVisible = false;
            LoginIcon.HeightRequest = Constants.LoginIconHeight;
            App.StartCheckifInternet(lbl_Nointernet, this);
           
            Entry_Username.Completed += (s, e) => Entry_Password.Focus();
            Entry_Password.Completed += (s, e) => SignInProcedure(s, e);


        }

        async void SignInProcedure(object sender, EventArgs e)
        {
            User user = new User(Entry_Username.Text, Entry_Password.Text);
            if (user.CheckInformation())
            {
                DisplayAlert("Login", "Login Success", "Cancel");
                //var result = await App.RestService.Login(user);
                var result = new Token();
                if (result != null)
                {
                   // App.UserDatabase.SaveUser(user);
                   // App.TokenDatabase.SaveToken(result);
                    if(Device.RuntimePlatform == Device.Android)
                    {
                        Application.Current.MainPage = new NavigationPage(new MainPage());
                    }

                    else if (Device.RuntimePlatform == Device.iOS)
                    {
                        await Navigation.PushModalAsync(new NavigationPage(new MainPage()));
                    }

                }
            }
            else
            {
                DisplayAlert("Login fail", "Login not Success, try again", "Cancel");

            }
        }
    }
}
