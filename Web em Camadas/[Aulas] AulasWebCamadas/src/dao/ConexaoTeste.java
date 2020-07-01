package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.PessoaDAO;
import model.Pessoa;



public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new Conexao().criarConexao();
		System.out.println("Conexão OK");
		Pessoa p1 = new Pessoa();
		PessoaDAO t1 = new PessoaDAO(con);
		
		p1.setEmail("ousado@cia.com");
		p1.setId(0);
		p1.setNome("Cleber");
		//t1.listarTodos();
		//t1.inserir(p1);
		//t1.inserir(p1);
		
		
		
		
		
		
	
	}

}