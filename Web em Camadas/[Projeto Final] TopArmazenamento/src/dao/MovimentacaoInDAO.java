package dao;

import java.sql.SQLException;
import java.util.List;

import model.Movimentacao;

public interface MovimentacaoInDAO {

	void Inserir(Movimentacao _objeto) throws SQLException;
	
	List<Movimentacao> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Movimentacao _objeto) throws SQLException;
	
	Movimentacao buscarPorId(int _id) throws SQLException;
}