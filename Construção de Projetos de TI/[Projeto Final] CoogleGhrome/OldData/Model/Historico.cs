using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OldData
{
    public class Historico
    {
        private int id;
        private String link;
        private String data;

        public int ID
        {
            get { return id; }
            set { id = value; }
        }

        public String Data
        {
            get { return data; }
            set { data = value; }
        }

        public String Link
        {
            get { return link; }
            set { link = value; }
        }
    }
}
