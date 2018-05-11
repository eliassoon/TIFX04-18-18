using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace Mellasapp.Models
{
    public class Constants
    {
		internal static readonly string NoInternetText;
		public static bool IsDev = true;
        public static Color BackgroundColor = Color.White;
        public static Color MainText = Color.Purple;

        public static int LoginIconHeight = 120;


        //--------Login----------
        public static string LoginUrl = "http://test.com/api/Auth/Login";
        public static string NoiternetText = "No Internet, please reconnect.";

        public static string NointernetText { get; internal set; }
    }
}
