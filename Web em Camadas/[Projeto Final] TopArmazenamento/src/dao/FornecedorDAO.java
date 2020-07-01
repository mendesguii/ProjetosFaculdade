package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

public class FornecedorDAO implements FornecedorInDAO {
	
	private Connection conexao;
	
	public FornecedorDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Inserir(Fornecedor _objeto) throws SQLException {
		String SQL = "INSERT INTO fornecedor (nome, telefone,email) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getTelefone());
		ps.setString(3, _objeto.getEmail());
		ps.execute();
		conexao.close();

	}

	@Override
	public List<Fornecedor> listarTodos() throws SQLException {
		List<Fornecedor> fornecedores  = new ArrayList<Fornecedor>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email , telefone FROM fornecedor";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String telefone = rs.getString(3);
			String email = rs.getString(4);
			Fornecedor p = new Fornecedor();
			p.setNome(nome);
			p.setId(id);
			p.setTelefone(telefone);
			p.setEmail(email);
			fornecedores.add(p);
		}
		conexao.close();
		return fornecedores;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM fornecedor WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);	
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Fornecedor _objeto) throws SQLException {
		String SQL = "UPDATE fornecedor SET nome = ?, telefone = ?, email = ?  WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getTelefone());	
		ps.setString(3, _objeto.getEmail());	
		ps.setInt(4, _objeto.getId());	
		return ps.execute();
	}

	@Override
	public Fornecedor buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, telefone ,email FROM fornecedor WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String telefone = rs.getString(3);
			String email = rs.getString(4);
			Fornecedor p = new Fornecedor();
		    p.setNome(nome);
			p.setId(id);
		    p.setTelefone(telefone);
		    p.setEmail(email);
			return p;
		}
		conexao.close();
		return null;
	}

}
