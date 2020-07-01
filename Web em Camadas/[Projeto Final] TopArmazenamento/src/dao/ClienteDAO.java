package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO implements ClienteInDAO{
	
private Connection conexao;
	
	public ClienteDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	
	@Override
	public void Inserir(Cliente _objeto) throws SQLException {
		
		String SQL = "INSERT INTO cliente (nome, email, telefone,senha) VALUES (?, ? ,? , ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		ps.setString(4, _objeto.getSenha());
		ps.execute();
		conexao.close();
	}


	@Override
	public List<Cliente> listarTodos() throws SQLException {
		
		List<Cliente> pessoas = new ArrayList<Cliente>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email, telefone ,senha FROM cliente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			String senha = rs.getString(5);
			Cliente p = new Cliente();
			p.setNome(nome);
			p.setId(id);
			p.setEmail(email);
			p.setTelefone(telefone);
			p.setSenha(senha);
			pessoas.add(p);
		}
		conexao.close();
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		
		String SQL = "DELETE FROM cliente WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Cliente _objeto) throws SQLException {
		
		String SQL = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, senha = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		ps.setString(4, _objeto.getSenha());
		ps.setInt(5, _objeto.getId());
		conexao.close();
		return ps.execute();
	}

	@Override
	public Cliente buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email,telefone,senha FROM cliente WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			String senha = rs.getString(5);
			Cliente p = new Cliente();
		    p.setNome(nome);
			p.setId(id);
			p.setEmail(email);
			p.setTelefone(telefone);
			p.setSenha(senha);
			return p;
		}
		conexao.close();
		return null;
	}
	
	
	

}
