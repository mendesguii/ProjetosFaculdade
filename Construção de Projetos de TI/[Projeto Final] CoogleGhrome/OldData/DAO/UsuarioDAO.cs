using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace OldData
{
    public class UsuarioDAO
    {
        Conexao con = new Conexao();
        private MySqlCommand SQL;
        private MySqlDataReader reader;

        public Boolean InserirUsuario(Usuario user)
        {
            String nome = user.Nome;
            String senha = user.Senha;
            String email = user.Email;
            Boolean check = true;
            
            String sqlCheck = "select * from usuario where email='"+email+"';";
            SQL = new MySqlCommand(sqlCheck, con.Connect());
            
            using (reader = SQL.ExecuteReader())
            {
                if (reader.Read())
                {
                  if (reader["email"].ToString() == email) check = false;
                  else check = true;

                }
            }
            con.Disconnect();
            if (check)
            {
                 String sqlInsert = "insert into usuario(nome,email,senha) values('"+nome+"','"+email+"','"+senha+"');";
                 SQL = new MySqlCommand(sqlInsert, con.Connect());
                  SQL.ExecuteNonQuery();
                  con.Disconnect();
                  return true;
                  
            }
            else return false;
            
   
        }
        public Usuario LoginUsuario(Usuario user)
        {
            String nome = user.Nome;
            String senha = user.Senha;
            String email = user.Email;
            Usuario userLogado = new Usuario();

            String sqlCheck = "select * from usuario where email='" + email + "' and senha= '" + senha + "';";
            SQL = new MySqlCommand(sqlCheck, con.Connect());

            using (reader = SQL.ExecuteReader())
            {
                if (reader.Read())
                {
                    if (reader["email"].ToString() == email && reader["senha"].ToString() == senha)
                    {
                        userLogado.Email = reader["email"].ToString();
                        userLogado.Nome = reader["nome"].ToString();
                        userLogado.ID = int.Parse(reader["id"].ToString());     
                    }
                }
            }
            con.Disconnect();
            return userLogado;
        }

        }
}
