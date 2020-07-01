using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Model;

namespace Data
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
            try { 
            
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
            
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            
            
   
        }
        public Usuario LoginUsuario(Usuario user)
        {
            String nome = user.Nome;
            String senha = user.Senha;
            String email = user.Email;
            Usuario userLogado = new Usuario();

            String sqlCheck = "select * from usuario where email='" + email + "' and senha= '" + senha + "';";
            SQL = new MySqlCommand(sqlCheck, con.Connect());
            try
            {
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
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }  
            
        }
        public Usuario BuscarPorIdUsuario(int id)
        {
             Usuario u1 = new Usuario();

            String sqlCheck = "select * from usuario where id='" + id.ToString() + "';";
            SQL = new MySqlCommand(sqlCheck, con.Connect());
            try
            {
                using (reader = SQL.ExecuteReader())
                {
                    if (reader.Read())
                    {
                         u1.Email = reader["email"].ToString();
                         u1.Nome = reader["nome"].ToString();
                         u1.ID = int.Parse(reader["id"].ToString());
                    }
                }
                con.Disconnect();
                return u1;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

        }
        
        }
}
