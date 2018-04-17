using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class Request
    {
        public int request_id { get; set; }
        public DateTime requestDate { get; set; }
        public DateTime editDate { get; set; }
        public string message { get; set; }
        public string status { get; set; }
        public User user { get; set; }

        public Request(int request_id, DateTime requestDate, DateTime editDate, string message, string status, User user)
        {
            this.request_id = request_id;
            this.requestDate = requestDate;
            this.editDate = editDate;
            this.message = message;
            this.status = status;
            this.user = user;
        }

        public override string ToString()
        {
            return "request_id=" + request_id + ", requestDate=" + requestDate + ", editDate=" + editDate + ", status=" + status + ", user=" + user;
        }
    }
}