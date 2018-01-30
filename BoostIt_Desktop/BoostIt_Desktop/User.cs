using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class User
    {
        public int Id { get; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Role { get; set; }

        public User(int id, string username, string password, int roleId)
        {
            this.Id = id;
            this.Username = username;
            this.Password = password;
            if (roleId == 0)
                Role = "Student";
            else if (roleId == 1)
                Role = "Teacher";
            else
                Role = "Other";
        }

        public override string ToString()
        {
            return "{User: Id=" + Id + ", Username=" + Username + ", Password=" + Password + ", Role=" + Role + "} ";
        }
    }
}
