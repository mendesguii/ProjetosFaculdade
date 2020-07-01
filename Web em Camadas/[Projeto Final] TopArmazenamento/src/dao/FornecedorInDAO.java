  
package dao;

import java.sql.SQLException;
import java.util.List;

import model.Fornecedor;

public interface FornecedorInDAO {

	void Inserir(Fornecedor _objeto) throws SQLException;
	
	List<Fornecedor> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Fornecedor _objeto) throws SQLException;
	
	Fornecedor buscarPorId(int _id) throws SQLException;
}