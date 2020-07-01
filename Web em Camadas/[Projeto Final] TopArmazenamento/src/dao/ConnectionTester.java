package dao;

import java.sql.Connection;
import java.sql.SQLException;

import model.Cliente;

public class ConnectionTester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		CriadorConexao criador = new CriadorConexao();
		Connection conexao = criador.fazerConexao();
		Cliente c123 = new Cliente(0,"Vendas e Ousadias","vendaseousadias2003@gmail.com","12354-1231","123456");
	
		
		ClienteDAO c1dao = new ClienteDAO(conexao);
		c1dao.Inserir(c123);
		
		
		
		
				
	}

}
