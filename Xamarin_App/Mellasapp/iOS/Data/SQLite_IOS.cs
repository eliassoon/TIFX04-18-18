using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;


using Mellasapp.Data;
using Xamarin.Forms;
using Mellasapp.iOS.Data;

[assembly: Dependency (typeof(SQLite_IOS))]
namespace Mellasapp.iOS.Data
{
    public class SQLite_IOS : ISQLite
    {
        public SQLite_IOS() { }
    public SQLite.SQLiteConnection GetConnection()
        {
        var fileName = "Testdb.db3";
        var documentPath = Environment.GetFolderPath(Environment.SpecialFolder.Personal);
        var libraryPath = Path.Combine(documentPath, "..", "Library");
        var path = Path.Combine(libraryPath, fileName);
        var connection = new SQLite.SQLiteConnection(path);
        return connection;
        }

    }
}
