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
        private List<ClassMember> members = new List<ClassMember>();

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
                if (username.Equals(u.username) && u.role == 0)
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

        public IEnumerable GetTeachers()
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "TeacherList");
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

        public IEnumerable GetStudents()
        {
            WebRequest request = WebRequest.Create(basicConnectionString + "StudentsList");
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

        public void InsertClassMember(ClassMember cm)
        {
            /*string jsonStr = JsonConvert.SerializeObject(cm, Formatting.Indented);

            WebRequest request = WebRequest.Create(basicConnectionString + "ClassDetail");
            Console.WriteLine(jsonStr);
            byte[] data = Encoding.UTF8.GetBytes(jsonStr);
            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = data.Length;

            using (var stream = request.GetRequestStream())
            {
                stream.Write(data, 0, data.Length);
            }

            WebResponse response = request.GetResponse();*/
            members.Add(cm);
        }

        public IEnumerable GetGroups()
        {
            return members;
        }

        public IEnumerable GetClassDescriptions()
        {
            List<string> descriptions = new List<string>();
            descriptions.Add(members[0].classDescription);
            for(int i = 1; i < members.Count; i++)
            {
                if (!members[i].classDescription.Equals(members[i - 1].classDescription))
                {
                    descriptions.Add(members[i].classDescription);
                }
            }

            return descriptions;
        }

        public void RemoveGroup(ClassMember selectedItem)
        {
            members.Remove(selectedItem);
        }

        public User GetTeacherForClass(string classDescription)
        {
            User foundUser = null;
            for (int i = 0; i < members.Count && foundUser == null; i++)
            {
                if (classDescription.Equals(members[i].classDescription))
                {
                    foundUser = members[i].teacher;
                }
            }
            return foundUser;
        }

        public IEnumerable GetStudentsForClass(string classDescription)
        {
            List<User> students = new List<User>();
            foreach(ClassMember cm in members)
            {
                if (classDescription.Equals(cm.classDescription))
                {
                    students.Add(cm.student);
                }
            }
            return students;
        }

        public void RemoveAllMembersForClass(string v)
        {
            List<ClassMember> newMembers = new List<ClassMember>();
            foreach (ClassMember member in members)
            {
                if (!v.Equals(member.classDescription))
                {
                    newMembers.Add(member);
                }
            }
            members = newMembers;
        }
    }
}
