using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Usuario
    {
        
        private int id;
        private String email;
        private String nome;
        private String senha;

        public int ID
        {
            get { return id; }
            set { id = value; }
        }
        public String Email
        {
            get { return email; }
            set { email = value; }
        }
        public String Nome
        {
            get { return nome; }
            set { nome = value; }
        }
        public String Senha
        {
            get { return senha; }
            set { senha = value; }
        }
       

    }
}
