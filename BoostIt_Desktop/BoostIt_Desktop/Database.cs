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
        private string basicConnectionString = "http://192.168.1.5:8080/BoostIt/WS/";
        private static Database instance;
        private List<Request> requests = new List<Request>();

        public Database() { }
        public static Database GetInstance()
        {
            if (instance == null)
            {
                instance = new Database();
            }
            return instance;
        }

        public bool ChkLogin(string username, string password)
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "UserList");
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
            foreach (User u in users)
            {
                if (username.Equals(u.username))
                    retVal = true;
            }
            return retVal;
        }

        #region/********User-Management********/
            #region/********GET-Finished********/
        public IEnumerable GetUsers()
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "UserList");
            request.Method = "GET";
            WebResponse response = request.GetResponse();
            List<User> users = new List<User>();
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
        #endregion
            #region/********ADD-Finished********/
        public string InsertUser(User usrToInsert)
        {
            string jsonStr = JsonConvert.SerializeObject(usrToInsert, Formatting.Indented);

            WebRequest request = WebRequest.Create(basicConnectionString + "UserDetail");

            byte[] data = Encoding.UTF8.GetBytes(jsonStr);
            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = data.Length;

            using (var stream = request.GetRequestStream())
            {
                stream.Write(data, 0, data.Length);
            }

            WebResponse response = request.GetResponse();

            string status = ((HttpWebResponse)response).StatusDescription;
            return status;
        }
        #endregion
            #region/********REMOVE-Finished********/
        public string RemoveUser(User usrToRemove)
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "UserDetail?user_id="+usrToRemove.user_id);
            
            request.Method = "DELETE";
            request.ContentType = "application/json";
            WebResponse response = request.GetResponse();
            string status = ((HttpWebResponse)response).StatusDescription;

            return status;
        }
        #endregion
            #region/********UPDATE-Finished********/
        public string UpdateUser(User updatedUser)
        {
            string jsonStr = JsonConvert.SerializeObject(updatedUser, Formatting.Indented);

            WebRequest request = WebRequest.Create(basicConnectionString + "UserDetail");

            byte[] data = Encoding.UTF8.GetBytes(jsonStr);
            request.Method = "PUT";
            request.ContentType = "application/json";
            request.ContentLength = data.Length;

            using (var stream = request.GetRequestStream())
            {
                stream.Write(data, 0, data.Length);
            }

            WebResponse response = request.GetResponse();

            string status = ((HttpWebResponse)response).StatusDescription;
            return status;
        }
        #endregion
        #endregion
        #region/********Request-Management********/
            #region/********LOAD-WIP********/
        public void LoadRequests()
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "RequestList");
            request.Method = "GET";
            WebResponse response = request.GetResponse();
            using (var webserviceResponse = (WebResponse)request.GetResponse())
            {
                using (var reader = new StreamReader(webserviceResponse.GetResponseStream()))
                {
                    string json = reader.ReadToEnd();
                    requests = JsonConvert.DeserializeObject<List<Request>>(json);
                }
            }
        }
        #endregion
            #region/********GET-WIP********/
        public IEnumerable GetRequests()
        {
            return requests;
        }
        #endregion
        #endregion
    }
}
