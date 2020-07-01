using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OldData
{
    public class Favorito
    {

        private int id;
        private String link;
        private String nome;

        public int ID
        {
            get { return id; }
            set { id = value; }
        }

        public String Link
        {
            get { return link; }
            set { link = value; }
        }
        public String Nome
        {
            get { return nome; }
            set { nome = value; }
        }

    }
}
