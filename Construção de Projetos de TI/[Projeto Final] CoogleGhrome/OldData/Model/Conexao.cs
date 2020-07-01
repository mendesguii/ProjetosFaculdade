using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace OldData
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
            conn = new MySqlConnection(connString);
            conn.Open();
            return conn;
        }
        
        public void Disconnect()
        {
            conn.Close();
        }
               
    }

}
