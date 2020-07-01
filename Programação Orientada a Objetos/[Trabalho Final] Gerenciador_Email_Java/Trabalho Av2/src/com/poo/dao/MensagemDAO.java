package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Mensagem;

public class MensagemDAO {

	public void Create(Mensagem mensagem)
	{
		Connection con =  ConnectionFactory.getConnection();
		System.out.println("Conexao OK");
		PreparedStatement stmt = null;

		String sql = "insert into mensagem (assunto,mensagem) values(?,?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mensagem.getAssunto());
			stmt.setString(2, mensagem.getMensagem());

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
		public List<Mensagem> readAll()
		{
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String sql = "select * from mensagem";
			List<Mensagem> mensagems = new ArrayList<Mensagem>();

			try
			{
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next())
				{
					Mensagem mensagem = new Mensagem();
					mensagem.setAssunto(rs.getString("assunto"));
					mensagem.setMensagem(rs.getString("mensagem"));
					mensagems.add(mensagem);
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

			return mensagems;

		}
		public void Delete(Mensagem mensagem)
		{
			Connection con =  ConnectionFactory.getConnection();
			System.out.println("Conexao OK");
			PreparedStatement stmt = null;

			String sql = "delete from mensagem where id_mensagem = ?";

			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, String.valueOf(mensagem.getId_mensagem()));

				stmt.executeUpdate();
				System.out.println("mensagem excluido com Sucesso");

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
		public String RetornaIDMensagem(Mensagem mensagem) // Retorna Id da mensagem
		{
			Connection con = ConnectionFactory.getConnection();
			//System.out.println("Conexao OK");
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String id = null;
			String sql = "select id_mensagem from mensagem where Assunto = ? and mensagem = ?";

			try
			{
				stmt = con.prepareStatement(sql);
				stmt.setString(1, mensagem.getAssunto());
				stmt.setString(2, mensagem.getMensagem());
				rs = stmt.executeQuery();
				while (rs.next())
				{
				id = rs.getString("id_mensagem");
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
