package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Fornecedor;
import model.Item;

public class ItemDAO implements ItemInDAO {
	
	private Connection conexao;
	
	public ItemDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Item _objeto) throws SQLException {
		String SQL = "INSERT INTO item (partNumber, descricao, unidadeDeMedida , idCliente ,idFornecedor) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _objeto.getPartNumber());
		ps.setString(2, _objeto.getDescricao());
		ps.setString(3, _objeto.getUnidadeDeMedida());
		ps.setInt(4,_objeto.getCliente().getId());
		ps.setInt(5,_objeto.getFornecedor().getId());
		ps.execute();
		conexao.close();

	}

	@Override
	public List<Item> listarTodos() throws SQLException {
		List<Item> itens  = new ArrayList<Item>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, partNumber, descricao, unidadeDeMedida , idCliente ,idFornecedor FROM item";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String partNumber = rs.getString(2);
			String descricao = rs.getString(3);
			String unidadeDeMedida = rs.getString(4);
			int idCliente = rs.getInt(5);
			int idFornecedor = rs.getInt(6);
			ClienteDAO cd = new ClienteDAO(this.conexao);
			Cliente c1 = cd.buscarPorId(idCliente);
			FornecedorDAO fd = new FornecedorDAO(this.conexao);
			Fornecedor f1 = fd.buscarPorId(idFornecedor);
			Item p = new Item(id,partNumber,descricao,unidadeDeMedida,c1,f1);
			itens.add(p);
		}
		conexao.close();
		return itens;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM item WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Item _objeto) throws SQLException {
		String SQL = "UPDATE item SET partNumber= ? ,descricao= ? ,unidadeDeMedida= ? ,idCliente= ? ,idFornecedor= ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getPartNumber());
		ps.setString(2, _objeto.getDescricao());
		ps.setString(3, _objeto.getUnidadeDeMedida());
		ps.setInt(4,_objeto.getCliente().getId());
		ps.setInt(5,_objeto.getFornecedor().getId());
		ps.setInt(6,_objeto.getId());
		
		return ps.execute();
	}

	@Override
	public Item buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, partNumber, descricao, unidadeDeMedida , idCliente ,idFornecedor FROM item WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String partNumber = rs.getString(2);
			String descricao = rs.getString(3);
			String unidadeDeMedida = rs.getString(4);
			int idCliente = rs.getInt(5);
			int idFornecedor = rs.getInt(6);
			ClienteDAO cd = new ClienteDAO(this.conexao);
			Cliente c1 = cd.buscarPorId(idCliente);
			FornecedorDAO fd = new FornecedorDAO(this.conexao);
			Fornecedor f1 = fd.buscarPorId(idFornecedor);
			Item p = new Item(id,partNumber,descricao,unidadeDeMedida,c1,f1);
			return p;
		}
		conexao.close();
		return null;
	}

}
