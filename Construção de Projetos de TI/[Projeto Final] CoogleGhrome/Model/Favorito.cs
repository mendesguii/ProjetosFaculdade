using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Favorito
    {

        private int id;
        private String link;
        private String nome;
        private Usuario usuario;

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
        public Usuario Usuario
        {
            get { return usuario; }
            set { usuario = value; }
        }

      


    }
}
