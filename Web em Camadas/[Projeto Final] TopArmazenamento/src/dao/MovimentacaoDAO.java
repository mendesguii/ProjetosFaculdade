package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Armazem;
import model.Item;
import model.Movimentacao;

public class MovimentacaoDAO implements MovimentacaoInDAO {
	
	private Connection conexao;
	
	public MovimentacaoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Inserir(Movimentacao _objeto) throws SQLException {
		String SQL = "INSERT INTO movimentacao (idItem, idArmazem, quantidade , preco ) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _objeto.getItem().getId());
		ps.setInt(2, _objeto.getArmazem().getId());
		ps.setFloat(3, _objeto.getQuantidade());
		ps.setFloat(4,_objeto.getPreco());
		ps.execute();
		conexao.close();
	}

	@Override
	public List<Movimentacao> listarTodos() throws SQLException {
		List<Movimentacao> itens  = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, idItem, idArmazem, quantidade , preco FROM movimentacao";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			int idItem = rs.getInt(2);
			int idArmazem = rs.getInt(3);
			float quantidade = rs.getFloat(4);
			float preco = rs.getFloat(5);
			
			ItemDAO idao = new ItemDAO(this.conexao);
			Item i1 = idao.buscarPorId(idItem);
			ArmazemDAO ad = new ArmazemDAO(this.conexao);
			Armazem a1 = ad.buscarPorId(idArmazem);
			Movimentacao p = new Movimentacao(id,a1,i1,quantidade,preco);
			itens.add(p);
		}
		conexao.close();
		return itens;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM movimentacao WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Movimentacao _objeto) throws SQLException {
		String SQL = "UPDATE movimentacao SET idItem= ? ,idArmazem= ? ,quantidade= ? ,preco= ?  WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getItem().getId());
		ps.setInt(2, _objeto.getArmazem().getId());
		ps.setFloat(3, _objeto.getQuantidade());
		ps.setFloat(4,_objeto.getPreco());
		ps.setInt(5,_objeto.getId());
		
		return ps.execute();
	}

	@Override
	public Movimentacao buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, idItem, idArmazem, quantidade , preco FROM movimentacao WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
						
			int id = rs.getInt(1);
			int idItem = rs.getInt(2);
			int idArmazem = rs.getInt(3);
			float quantidade = rs.getFloat(4);
			float preco = rs.getFloat(5);
			
			ItemDAO idao = new ItemDAO(this.conexao);
			Item i1 = idao.buscarPorId(idItem);
			ArmazemDAO ad = new ArmazemDAO(this.conexao);
			Armazem a1 = ad.buscarPorId(idArmazem);
			Movimentacao p = new Movimentacao(id,a1,i1,quantidade,preco);
			return p;
		}
		conexao.close();
		return null;
	}

}
