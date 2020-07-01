using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Windows.Forms;

namespace OldData
{
    public class HistoricoDAO
    {
        Conexao con = new Conexao();
        private MySqlCommand SQL;
        private MySqlDataReader reader;

       public void InserirHistorico(Usuario u1, List<Historico> HistList)
       {
           int id = u1.ID;
           String sqlInsert = "insert into historico(id_usuario,link,data) values ";
           foreach (var itemHistorico in HistList)
           {
               sqlInsert += "('" + id.ToString() +"','" + itemHistorico.Link + "','" + itemHistorico.Data + "'), ";  
           }
           sqlInsert = sqlInsert.Remove(sqlInsert.Length - 2);
           sqlInsert += ";";
           SQL = new MySqlCommand(sqlInsert, con.Connect());
           SQL.ExecuteNonQuery();
           con.Disconnect();

        }
       
        public void ExtracaoHistorico(Usuario u1, ListView l1, List<Historico> HistoricoCompleto)
       {
           String sqlCheck = "select * from historico where id_usuario='" + u1.ID.ToString() + "';";
           SQL = new MySqlCommand(sqlCheck, con.Connect());
           l1.Items.Clear();
           using (reader = SQL.ExecuteReader())
           {
               while (reader.Read())
               {
                   ListViewItem item = new ListViewItem(reader["link"].ToString());
                   item.SubItems.Add(reader["data"].ToString());
                   l1.Items.Add(item);
               }
           }
           con.Disconnect();

           foreach (var itemHistorico in HistoricoCompleto)
           {
               ListViewItem item = new ListViewItem(itemHistorico.Link);
               item.SubItems.Add(itemHistorico.Data);
               l1.Items.Add(item);
           }
       }
       
        public void RemoverHistorico(Usuario u1, List<Historico> HistList)
       {
            int id = u1.ID;
            String sqlInsert = "delete from historico where id_usuario=" + id.ToString() + " and data in (";
            foreach (var itemHistorico in HistList)
           {
                sqlInsert += "'"+ itemHistorico.Data + "',";  
           }
            sqlInsert = sqlInsert.Remove(sqlInsert.Length - 1); // Limpando a ultima virgula
            sqlInsert += ");";
            SQL = new MySqlCommand(sqlInsert, con.Connect());
            SQL.ExecuteNonQuery();
            con.Disconnect();
       }
    
    
    }

 
}
