using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class ClassMember
    {
        public User teacher { get; set; }
        public User student { get; set; }
        public string classDescription { get; set; }

        public ClassMember(User teacher, User student, string classStr){
            this.teacher = teacher;
            this.student = student;
            this.classDescription = classStr;
        }

        public override string ToString()
        {
            return "Teacher="+teacher+", Student="+student+", Class="+classDescription;
        }
    }
}
