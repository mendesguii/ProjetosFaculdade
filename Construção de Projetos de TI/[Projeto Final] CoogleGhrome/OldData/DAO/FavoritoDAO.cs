using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Windows.Forms;

namespace OldData
{
    public class FavoritoDAO
    {
        Conexao con = new Conexao();
        private MySqlCommand SQL;
        private MySqlDataReader reader;

        public void InserirFavorito(Usuario u1, Favorito fav, List<Favorito> Favoritos)
       { 
          String sqlInsert = "insert into favorito(id_usuario,link,nome) values('" + u1.ID.ToString() + "','" + fav.Link + "','" + fav.Nome + "');";
          SQL = new MySqlCommand(sqlInsert, con.Connect());
          SQL.ExecuteNonQuery();
          con.Disconnect();
          Favoritos.Add(fav);
       }

       public void ExtracaoFavoritos(Usuario u1, List<Favorito> Favoritos)
       {
           String sqlCheck = "select * from favorito where id_usuario='" + u1.ID.ToString() + "';";
           SQL = new MySqlCommand(sqlCheck, con.Connect());

           using (reader = SQL.ExecuteReader())
           {
               while (reader.Read())
               {
                   // Adicionando a Lista de Exibição
                   //ListViewItem item = new ListViewItem(reader["nome"].ToString());
                   //item.SubItems.Add(reader["link"].ToString());
                   //l1.Items.Add(item);
                   
                   // Adicionando a Lista de Favoritos
                   Favorito f1 = new Favorito();
                   f1.Nome = reader["nome"].ToString();
                   f1.Link = reader["link"].ToString();
                   Favoritos.Add(f1);                
               }
           }
           con.Disconnect(); 
       }
       public void RemoverFavorito(Usuario u1, List<Favorito> listFav)
       {
           int id = u1.ID;
           String sqlInsert = "delete from favorito where id_usuario=" + id.ToString() + " and nome in (";
           foreach (var itemFavorito in listFav)
           {
               sqlInsert += "'" + itemFavorito.Nome + "',";
           }
           sqlInsert = sqlInsert.Remove(sqlInsert.Length - 1); // Limpando a ultima virgula
           sqlInsert += ");";
           SQL = new MySqlCommand(sqlInsert, con.Connect());
           SQL.ExecuteNonQuery();
           con.Disconnect();
       }
 
      
     }
}
