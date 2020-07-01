package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Email;
import com.poo.model.EmailMensagem;

public class EmailDAO {

	public void Create(Email email)
	{
		Connection con =  ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "insert into email(id_cliente_destino,id_cliente_origem,id_mensagem,data_envio) values(?,?,?,(select current_timestamp from dual))";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, String.valueOf(email.getId_cliente_destino()));
			stmt.setString(2, String.valueOf(email.getId_cliente_origem()));
			stmt.setString(3, String.valueOf(email.getId_mensagem()));
			//stmt.setString(4, String.valueOf(email.getData_envio()));

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
		public ResultSet readAll(String email_1)
		{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String sql = "select c1.email Email,e.data_envio Data ,m.assunto Assunto ,m.mensagem Mensagem from email e, mensagem m, cliente c1, cliente c2 where 1=1 and c1.id_cliente = e.id_cliente_origem and c2.id_cliente = e.id_cliente_destino and e.id_mensagem = m.id_mensagem and c2.email = ?";
			List<EmailMensagem> emails = new ArrayList<EmailMensagem>();

			try
			{
				stmt = con.prepareStatement(sql);
				stmt.setString(1, email_1);
				rs = stmt.executeQuery();
				/*while (rs.next())
				{
					EmailMensagem email = new EmailMensagem();
					email.setData_envio(rs.getString("data_envio"));
					email.setAssunto(rs.getString("assunto"));
					email.setEmail_origem(rs.getString("email_origem"));
					email.setMensagem(rs.getString("mensagem"));
					emails.add(email);
				}*/


				System.out.println("Pesquisa feita com sucesso");
			}
			catch(SQLException e)
			{
				System.out.println("Erro ao ler tabela");
			}
			finally{
			//	ConnectionFactory.closeConnection(con,stmt);
			}

			return rs;

		}
		public void Delete(Email email)
		{
			Connection con =  ConnectionFactory.getConnection();
			PreparedStatement stmt = null;

			String sql = "delete from email where data_envio = ? and id_cliente_origem = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, String.valueOf(email.getData_envio()));
				stmt.setString(2, String.valueOf(email.getId_cliente_origem()));
				

				stmt.executeUpdate();
				System.out.println("Email excluido com Sucesso");

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
		/*	public void Update (Email email)
		{
			Connection con =  ConnectionFactory.getConnection();
			System.out.println("Conexao OK");
			PreparedStatement stmt = null;

			String sql = "update email set nome = ? where matricula = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, email.getNome());
				stmt.setString(1, email.getMatricula());

				stmt.executeUpdate();
				System.out.println("Informacao do email atualizada com Sucesso");

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
*/
		public String Id_Email(Email email)
		{
			Connection con = ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String id = null;
			String sql = "select id_email from email where id_cliente_origem = ? and data_envio = ?";

			try
			{
				stmt = con.prepareStatement(sql);
				stmt.setString(1, String.valueOf(email.getId_cliente_origem()));
				System.out.println(String.valueOf(email.getId_cliente_origem()));
				System.out.println(email.getData_envio());
				stmt.setString(2, email.getData_envio());
				rs = stmt.executeQuery();
				while (rs.next())
				{	
					id = rs.getString("id_email");
					System.out.println(id);
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
			return id;
		}
		
		
	}
