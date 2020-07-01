using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Windows.Forms;
using Model;

namespace Data
{
    public class HistoricoDAO
    {
        Conexao con = new Conexao();
        private MySqlCommand SQL;
        private MySqlDataReader reader;

       public bool InserirHistorico(Usuario u1, List<Historico> HistList)
       {
           int id = u1.ID;
           String sqlInsert = "insert into historico(id_usuario,link,data) values ";
           try
           {
               foreach (var itemHistorico in HistList)
               {
                   sqlInsert += "('" + id.ToString() + "','" + itemHistorico.Link + "','" + itemHistorico.Data + "'), ";
               }
               sqlInsert = sqlInsert.Remove(sqlInsert.Length - 2);
               sqlInsert += ";";
               SQL = new MySqlCommand(sqlInsert, con.Connect());
               SQL.ExecuteNonQuery();
               con.Disconnect();
               return true;
           }
           catch (MySqlException e)
           {
               throw new Exception(e.Message);
           }
           return false;
        }

       public List<Historico> ExtracaoHistorico(Usuario u1)
       {
           String sqlCheck = "select * from historico where id_usuario='" + u1.ID.ToString() + "';";
           SQL = new MySqlCommand(sqlCheck, con.Connect());
           List<Historico> resultado = new List<Historico>();
           try
           {
               
               using (reader = SQL.ExecuteReader())
               {
                   while (reader.Read())
                   {
                       Historico h1 = new Historico();
                       /*UsuarioDAO ud = new UsuarioDAO();
                       Usuario user = new Usuario();
                       user = ud.BuscarPorIdUsuario(int.Parse(reader["id_usuario"].ToString()));*/
                       h1.Usuario = u1;
                       h1.ID = int.Parse(reader["id"].ToString());
                       h1.Link= reader["link"].ToString();
                       h1.Data = reader["data"].ToString();
                       resultado.Add(h1);
                   }
               }
               con.Disconnect();
               return resultado;               
           }
           catch (MySqlException e)
           {
               throw new Exception(e.Message);
           }
       }
       
        public bool RemoverHistorico(Usuario u1, List<Historico> HistList)
       {
            int id = u1.ID;
            String sqlInsert = "delete from historico where id_usuario=" + id.ToString() + " and data in (";
            try
            {
                foreach (var itemHistorico in HistList)
                {
                    sqlInsert += "'" + itemHistorico.Data + "',";
                }
                sqlInsert = sqlInsert.Remove(sqlInsert.Length - 1); // Limpando a ultima virgula
                sqlInsert += ");";
                SQL = new MySqlCommand(sqlInsert, con.Connect());
                SQL.ExecuteNonQuery();
                con.Disconnect();
                return true;
            }
            catch (MySqlException e)
            {
                throw new Exception(e.Message);
            }
            return false;
       }
    
    
    }

 
}
