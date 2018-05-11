using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using SQLite;
using Mellasapp.Models;

namespace Mellasapp.Data
{
    public class TokenDatabaseController
    {
        static object locker = new object();

        SQLiteConnection database;

        public TokenDatabaseController()

        {
            database = DependencyService.Get<ISQLite>().GetConnection();
            database.CreateTable<User>();

        }

        public Token GetUser()

        {
            lock (locker)
            {
                if (database.Table<Token>().Count() == 0)
                {
                    return null;
                }
                else
                {
                    return database.Table<Token>().First();

                }
            }
        }

        public int SaveUser(Token token)

        {
            lock (locker)
            {
                if (token.Id != 0)
                {
                    database.Update(token);
                    return token.Id;
                }
                else
                {
                    return database.Insert(token);
                }
            }
        }


        public int DeleteToken(int id)
        {
            lock (locker)

            {
                return database.Delete<Token>(id);
            }
        }

		internal object GetToken()
		{
			throw new NotImplementedException();
		}

		internal void SaveToken(Token result)
		{
			throw new NotImplementedException();
		}
	}
}
