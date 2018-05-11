using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


using Mellasapp.Models;
using Mellasapp.Views;


using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Mellasapp.Data
{
    public interface INetworkConnection
    {
       
        bool IsConnected { get; }
        void CheckNetworkConnection();

    }
}
