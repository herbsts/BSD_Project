using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.OleDb;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace BoostIt_Desktop
{
    class Database
    {
        private string cs = ConfigurationManager.ConnectionStrings["OracleDatabase"].ConnectionString;
        private static Database instance;
        private List<User> users = new List<User>();
        public Database() { }
        public static Database GetInstance()
        {
            if (instance == null)
            {
                instance = new Database();
            }
            return instance;
        }

        public IEnumerable LoadUsers()
        {
            WebRequest request = WebRequest.Create("http://192.168.194.206:8080/BoostIt/WS/UserList");
            Console.WriteLine(request.GetResponse().GetResponseStream());
            request.Method = "GET";
            WebResponse response = request.GetResponse();
            users.Clear();
            using (var webserviceResponse = (WebResponse)request.GetResponse())
            {
                using (var reader = new StreamReader(webserviceResponse.GetResponseStream()))
                {
                    string json = reader.ReadToEnd();
                    users = JsonConvert.DeserializeObject<List<User>>(json);
                }
            }
            return users;
        }

        public IEnumerable GetUsers()
        {
            return users;
        }

        public bool ChkLogin(string username, string password)
        {
            /*string retVal = null;
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

            return retVal;*/

            WebRequest request = WebRequest.Create("http://192.168.194.206:8080/BoostIt/WS/UserList");
            Console.WriteLine(request.GetResponse().GetResponseStream());
            request.Method = "GET";
            WebResponse response = request.GetResponse();
            List<User> users;
            bool retVal = false;
            using (var webserviceResponse = (WebResponse)request.GetResponse())
            {
                using (var reader = new StreamReader(webserviceResponse.GetResponseStream()))
                {
                    string json = reader.ReadToEnd();
                    users = JsonConvert.DeserializeObject<List<User>>(json);
                }
            }
            foreach(User u in users)
            {
                if (username.Equals(u.Username))
                    retVal = true;
            }
            return retVal;
        }

        internal void SetUser(string username, string password)
        {
            //u = new User(username, password);
        }

        public void RemoveUser(User selectedItem)
        {
            users.Remove(selectedItem);
        }

        public void InsertUser(User usrToInsert)
        {
            /*string json = JsonConvert.SerializeObject(usrToInsert, Formatting.Indented);

            var request = WebRequest.Create("http://192.168.194.206:8080/BoostIt/WS/UserDetail");

            var data = Encoding.ASCII.GetBytes(json);

            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = data.Length;

            using (var stream = request.GetRequestStream())
            {
                stream.Write(data, 0, data.Length);
            }

            var response = (WebResponse)request.GetResponse();

            string responseString = new StreamReader(response.GetResponseStream()).ReadToEnd();
            return responseString;*/
            users.Add(usrToInsert);
        }
    }
}
