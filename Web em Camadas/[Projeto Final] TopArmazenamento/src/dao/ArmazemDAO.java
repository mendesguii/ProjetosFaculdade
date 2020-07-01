package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Armazem;

public class ArmazemDAO implements ArmazemInDAO {
	private Connection conexao;
	
	public ArmazemDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Inserir(Armazem _objeto) throws SQLException {
		String SQL = "INSERT INTO armazem (nome, endereco) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEndereco());
		ps.execute();

	}

	@Override
	public List<Armazem> listarTodos() throws SQLException {
		List<Armazem> armazens  = new ArrayList<Armazem>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, endereco FROM armazem";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String endereco = rs.getString(3);
			Armazem p = new Armazem();
			p.setNome(nome);
			p.setId(id);
			p.setEndereco(endereco);
			armazens.add(p);
		}
		
		return armazens;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		
		String SQL = "DELETE FROM armazem WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);	
		return ps.execute();
		
	}

	@Override
	public Boolean Atualizar(Armazem _objeto) throws SQLException {
		String SQL = "UPDATE armazem SET nome = ?, endereco = ?  WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEndereco());	
		ps.setInt(3, _objeto.getId());	
		return ps.execute();
	}

	@Override
	public Armazem buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, endereco FROM armazem WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String endereco = rs.getString(3);
			Armazem p = new Armazem();
		    p.setNome(nome);
			p.setId(id);
			p.setEndereco(endereco);
			return p;
		}
		
		return null;
	}

}
