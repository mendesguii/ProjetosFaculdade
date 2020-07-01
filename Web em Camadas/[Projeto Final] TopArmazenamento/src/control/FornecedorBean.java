package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.model.ListDataModel;

import dao.CriadorConexao;
import dao.FornecedorDAO;
import model.Fornecedor;
import util.JSFUtil;

public class FornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public FornecedorBean() {
		this.fornecedor	= new Fornecedor();
	}
	
	//Atributos
	private Fornecedor fornecedor;
	private ListDataModel<Fornecedor> listaModelfornecedores;
	private List<Fornecedor> listaFiltradaModelFornecedores;
	private List<Fornecedor> listaFornecedores;
	
	//M�todos de acesso
	public ListDataModel<Fornecedor> getListaModelfornecedores() {
		return listaModelfornecedores;
	}

	public void setListaModelfornecedores(ListDataModel<Fornecedor> listaModelfornecedores) {
		this.listaModelfornecedores = listaModelfornecedores;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<Fornecedor> getListaFiltradaModelFornecedores() {
		return listaFiltradaModelFornecedores;
	}

	public void setListaFiltradaModelFornecedors(List<Fornecedor> listaFiltradaModelFornecedores) {
		this.listaFiltradaModelFornecedores = listaFiltradaModelFornecedores;
	}

	
	//Mtodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.fornecedor = new Fornecedor();
	}
	
	public void Insert() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FornecedorDAO dao = new FornecedorDAO(conexao);
			
			dao.Inserir(this.fornecedor);
					
			this.fornecedor = new Fornecedor();
			
			this.listaFornecedores = dao.listarTodos();
			this.listaModelfornecedores = new ListDataModel<>(this.listaFornecedores);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor cadastrado com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um fornecedor" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.fornecedor = this.listaModelfornecedores.getRowData();
	}
	
	public void Delete() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FornecedorDAO dao = new FornecedorDAO(conexao);
			
			dao.Excluir(this.fornecedor.getId());
					
			this.fornecedor = new Fornecedor();
			
			this.listaFornecedores = dao.listarTodos();
			this.listaModelfornecedores = new ListDataModel<>(this.listaFornecedores);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor deletada com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.fornecedor = this.listaModelfornecedores.getRowData();
	}
	
	public void Update() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FornecedorDAO dao = new FornecedorDAO(conexao);
			
			dao.Atualizar(this.fornecedor);
					
			this.fornecedor = new Fornecedor();
			
			this.listaFornecedores = dao.listarTodos();
			this.listaModelfornecedores = new ListDataModel<>(this.listaFornecedores);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor atualizada com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void init() {
		
		try {
			CriadorConexao fab = new CriadorConexao();
			Connection con = fab.fazerConexao();
			
			FornecedorDAO dao = new FornecedorDAO(con);
				
			this.listaFornecedores = dao.listarTodos();
			this.listaModelfornecedores = new ListDataModel<>(this.listaFornecedores);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










