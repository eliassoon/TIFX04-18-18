using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

using System.IO;
using Xamarin.Forms;

using Mellasapp.Data;
using Mellasapp.Droid.Data;

[assembly: Dependency(typeof(SQLite_Android))]

namespace Mellasapp.Droid.Data
{
    public class SQLite_Android : ISQLite 
    {
        public SQLite_Android (){}
        public SQLite.SQLiteConnection GetConnection()
        {
            var sqliteFileName = "TestDB.db3";
            string documentPath = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal);
            var path = Path.Combine(documentPath, sqliteFileName);
            var conn = new SQLite.SQLiteConnection(path);

            return conn;        
        }
    }
}
