package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Cliente;

public class ClienteDAO {

	public void Create(Cliente cliente)
	{
		Connection con =  ConnectionFactory.getConnection();
		//System.out.println("Conexao OK");
		PreparedStatement stmt = null;

		String sql = "insert into cliente (nome,email,senha) values(?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getSenha());
			stmt.executeUpdate();
			System.out.println("Inserido com Sucesso");

		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erro ao inserir");
		}
		finally
		{
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
		public List<Cliente> readAll()
		{
			Connection con = ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String sql = "select * from cliente";
			List<Cliente> clientes = new ArrayList<Cliente>();

			try
			{
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next())
				{
					Cliente cliente = new Cliente();
					cliente.setNome(rs.getString("nome"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
					clientes.add(cliente);
				}


				System.out.println("Pesquisa feita com sucesso");
			}
			catch(SQLException e)
			{
				System.out.println("Erro ao ler tabela");
			}
			finally{
				ConnectionFactory.closeConnection(con,stmt);
			}

			return clientes;

		}
		public void Delete(Cliente cliente)
		{
			Connection con =  ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;

			String sql = "delete from cliente where email = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, cliente.getEmail());

				stmt.executeUpdate();
				System.out.println("cliente excluido com Sucesso");

			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Erro ao excluir");
			}
			finally
			{
				ConnectionFactory.closeConnection(con,stmt);
			}
		}
		public void Update (Cliente cliente)
		{
			Connection con =  ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;

			String sql = "update cliente set senha = ? where email = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, cliente.getSenha());
				stmt.setString(2, cliente.getEmail());

				stmt.executeUpdate();
				System.out.println("Informacao do cliente atualizada com Sucesso");

			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Erro ao atualizar info.");
			}
			finally
			{
				ConnectionFactory.closeConnection(con,stmt);
			}
		}
		public String Login(String email)
		{
			Connection con = ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String senha = null;
			String sql = "select senha from cliente where email = ?";

			try
			{
				stmt = con.prepareStatement(sql);
				stmt.setString(1, email);
				rs = stmt.executeQuery();
				while (rs.next())
				{
				senha = rs.getString("senha");
				//System.out.println("Senha retornada");
				
				}
			}
			catch(SQLException e)
			{
				System.out.println("Erro ao ler tabela");
			}
			finally{
				ConnectionFactory.closeConnection(con,stmt);
			}

			return senha;

		}
		public String PesquisarCliente(String email)
		{
			Connection con = ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String id = null;
			String sql = "select id_cliente from cliente where email = ?";

			try
			{
				stmt = con.prepareStatement(sql);
				stmt.setString(1, email);
				rs = stmt.executeQuery();
				while (rs.next())
				{
				id = rs.getString("id_cliente");
				//System.out.println("id do cliente retornado");
				
				}
			}
			catch(SQLException e)
			{
				System.out.println("Erro ao ler tabela");
			}
			finally{
				ConnectionFactory.closeConnection(con,stmt);
			}

			return id;

		}
		

	}
