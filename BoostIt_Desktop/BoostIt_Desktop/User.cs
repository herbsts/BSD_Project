using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class User
    {
        private string Username { get; set; }
        private string Password { get; set; }

        public User(string username, string password)
        {
            this.Username = username;
            this.Password = password;
        }
    }
}
