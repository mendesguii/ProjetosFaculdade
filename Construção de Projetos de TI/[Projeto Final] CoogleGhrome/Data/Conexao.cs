using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Data
{
    public class Conexao
    {
        private static String server = "remotemysql.com";
        private static String db = "bYFLQYWReL";
        private static String user = "bYFLQYWReL";
        private static String password = "hxrBJ7kiye";
        private static String connString = "Server=" + server + ";Database=" + db + ";Uid=" + user + ";Pwd=" + password + ";";
        private MySqlConnection conn;
        
        public MySqlConnection Connect()
        {
            try {
                conn = new MySqlConnection(connString);
                conn.Open();
                return conn;
            }
            catch (MySqlException e)
            {
                throw new Exception(e.Message);
            }
            
        }
        
        public void Disconnect()
        {
            try
            {
                conn.Close();
            }
            catch (MySqlException e)
            {
                throw new Exception(e.Message);
            }
            
        }
               
    }

}
