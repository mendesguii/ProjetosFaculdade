  
package dao;

import java.sql.SQLException;
import java.util.List;

import model.Item;

public interface ItemInDAO {

	void Inserir(Item _objeto) throws SQLException;
	
	List<Item> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Item _objeto) throws SQLException;
	
	Item buscarPorId(int _id) throws SQLException;
}