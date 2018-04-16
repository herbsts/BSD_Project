using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoostIt_Desktop
{
    class Request
    {
        private int request_id { get; set; }
        private DateTime requestDate { get; set; }
        private DateTime editDate { get; set; }
        private string status { get; set; }
        private User user { get; set; }

        public Request(int request_id, DateTime requestDate, DateTime editDate, string status, User user)
        {
            this.request_id = request_id;
            this.requestDate = requestDate;
            this.editDate = editDate;
            this.status = status;
            this.user = user;
        }

        public override string ToString()
        {
            return "request_id=" + request_id + ", requestDate=" + requestDate + ", editDate=" + editDate + ", status=" + status + ", user=" + user;
        }
    }
}
