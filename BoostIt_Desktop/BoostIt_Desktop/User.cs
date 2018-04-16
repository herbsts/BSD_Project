using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class User
    {
        public int user_id { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public EnumRoles role { get; set; }

        public User(int id, string username, string password, EnumRoles role)
        {
            this.user_id = id;
            this.username = username;
            this.password = password;
            this.role = role;
        }
        
        // override object.Equals
        public override bool Equals(object obj)
        {
            bool retVal = false;
            if (obj == null || GetType() != obj.GetType())
            {
                retVal = false;
            }
            else
            {
                User u = (User)obj;
                if (u.username.Equals(this.username) && u.password.Equals(this.password) && u.role.Equals(this.role))
                {
                    retVal = true;
                }
            }
            return retVal;
        }

        public override string ToString()
        {
            return username + ", " + role;
        }
    }
}
