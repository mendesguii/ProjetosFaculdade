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
    public class FavoritoDAO
    {
        Conexao con = new Conexao();
        private MySqlCommand SQL;
        private MySqlDataReader reader;

        public bool InserirFavorito(Usuario u1, Favorito fav, List<Favorito> Favoritos)
        {
            try
            {
                String sqlInsert = "insert into favorito(id_usuario,link,nome) values('" + u1.ID.ToString() + "','" + fav.Link + "','" + fav.Nome + "');";
                SQL = new MySqlCommand(sqlInsert, con.Connect());
                SQL.ExecuteNonQuery();
                con.Disconnect();
                Favoritos.Add(fav);
                return true;
            }

            catch (Exception ex)
            {
                throw new Exception(ex.Message);

            }
            return false;
        }

        public void ExtracaoFavoritos(Usuario u1, List<Favorito> Favoritos)
        {
            String sqlCheck = "select * from favorito where id_usuario='" + u1.ID.ToString() + "';";
            SQL = new MySqlCommand(sqlCheck, con.Connect());
            try
            {
                using (reader = SQL.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Favorito f1 = new Favorito();
                        f1.Usuario = u1;
                        f1.ID = int.Parse(reader["id"].ToString());
                        f1.Nome = reader["nome"].ToString();
                        f1.Link = reader["link"].ToString();
                        Favoritos.Add(f1);
                    }
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            con.Disconnect();
        }
        public bool RemoverFavorito(Usuario u1, List<Favorito> listFav)
        {
            int id = u1.ID;
            String sqlInsert = "delete from favorito where id_usuario=" + id.ToString() + " and nome in (";
            try
            {
                foreach (var itemFavorito in listFav)
                {
                    sqlInsert += "'" + itemFavorito.Nome + "',";
                }
                sqlInsert = sqlInsert.Remove(sqlInsert.Length - 1); // Limpando a ultima virgula
                sqlInsert += ");";
                SQL = new MySqlCommand(sqlInsert, con.Connect());
                SQL.ExecuteNonQuery();
                con.Disconnect();
                return true;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

            return false;
        }
        
        public bool EditarFavorito(Usuario u1, Favorito fav)
        {
            try
            {
                String sqlInsert = "update favorito set nome='" + fav.Nome + "',link='" + fav.Link + "' where id = '"+fav.ID.ToString()+"' ;";
                SQL = new MySqlCommand(sqlInsert, con.Connect());
                SQL.ExecuteNonQuery();
                con.Disconnect();
                return true;
            }

            catch (Exception ex)
            {
                throw new Exception(ex.Message);

            }
            return false;
        }
    
    
    
    }
}

