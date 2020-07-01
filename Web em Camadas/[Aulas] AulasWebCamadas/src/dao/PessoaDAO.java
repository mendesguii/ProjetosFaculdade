package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO implements PessoaInDao {

	private Connection conexao;
	
	public PessoaDAO(Connection _conexao)
	{
		this.conexao = _conexao;
	}

	@Override
	public void inserir(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into pessoa (nome,email) values(?,?)";
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, _objeto.getNome());
			stmt.setString(2, _objeto.getEmail());
			stmt.execute();
			System.out.println("Inserido com Sucesso");
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			System.out.println("Erro ao inserir");
		}
		finally
		{
			this.conexao.close();
		}

	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select * from Pessoa";
		List<Pessoa> Pessoas = new ArrayList<Pessoa>();

		try
		{
			stmt = this.conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				Pessoa p1 = new Pessoa();
				p1.setNome(rs.getString("nome"));
				p1.setEmail(rs.getString("email"));
				p1.setId(rs.getInt("id"));
				Pessoas.add(p1);
				System.out.println(rs.getString("nome"));
			}
			
			System.out.println("Pesquisa feita com sucesso");
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao ler tabela");
		}
		finally{
			this.conexao.close();
		}
		return Pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from pessoa where id = ?";
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, _id);
			return stmt.execute();		
		}
		catch(SQLException e){
			
			e.printStackTrace();
			System.out.println("Erro ao Excluir");
			return false;
		}
		finally
		{
			this.conexao.close();
		}
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update from pessoa set nome = ? , email = ? pessoa where id = ?";
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, _objeto.getNome());
			stmt.setString(2, _objeto.getEmail());
			stmt.setInt(3, _objeto.getId());
			stmt.executeUpdate();
			System.out.println("Excluido com Sucesso");
			return stmt.execute();
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			System.out.println("Erro ao Excluir");
			return false;
		}
		finally
		{
			this.conexao.close();
		}
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa p1 = new Pessoa();

		String sql = "select * from Pessoa where id = ?";
		List<Pessoa> Pessoas = new ArrayList<Pessoa>();

		try
		{
			stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, _id);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				p1.setNome(rs.getString("nome"));
				p1.setEmail(rs.getString("email"));
				p1.setId(rs.getInt("id"));
				Pessoas.add(p1);
			}
			
			System.out.println("Pesquisa feita com sucesso");
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao ler tabela");
		}
		finally{
			this.conexao.close();
		}
		return p1;
	}

}
