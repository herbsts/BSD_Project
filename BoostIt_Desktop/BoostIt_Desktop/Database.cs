using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class Database
    {
        private string cs = ConfigurationManager.ConnectionStrings["OracleDatabase"].ConnectionString;
        private static Database instance;
        private User u;
        public Database() { }
        public static Database GetInstance()
        {
            if (instance == null)
            {
                instance = new Database();
            }
            return instance;
        }

        public String ChkLogin(string username, string password)
        {
            string retVal = null;
            String commandText = "SELECT username FROM USERS WHERE username LIKE '%"+username+"%' AND password LIKE '%"+password+"%'";
            using (OleDbConnection conn = new OleDbConnection(cs))
            {
                OleDbCommand cmd = new OleDbCommand(commandText, conn);
                conn.Open();
                OleDbDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    retVal = Convert.ToString(reader.GetValue(0));
                }
                conn.Close();
            }

            return retVal;
        }

        internal void SetUser(string username, string password)
        {
            u = new User(username, password);
        }
    }
}
