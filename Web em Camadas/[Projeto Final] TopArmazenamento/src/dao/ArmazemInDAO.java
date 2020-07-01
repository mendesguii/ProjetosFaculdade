  
package dao;

import java.sql.SQLException;
import java.util.List;

import model.Armazem;

public interface ArmazemInDAO {

	void Inserir(Armazem _objeto) throws SQLException;
	
	List<Armazem> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Armazem _objeto) throws SQLException;
	
	Armazem buscarPorId(int _id) throws SQLException;
}