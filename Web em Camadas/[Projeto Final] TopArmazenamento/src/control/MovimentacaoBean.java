package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.model.ListDataModel;

import dao.CriadorConexao;
import dao.MovimentacaoDAO;
import model.Armazem;
import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Movimentacao;
import util.JSFUtil;

public class MovimentacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public MovimentacaoBean() {
		this.movimentacao	= new Movimentacao();
	}
	
	//Atributos
	private Movimentacao movimentacao;
	private Item item;
	private Cliente cliente;
	private Fornecedor fornecedor;
	private Armazem armazem;
	private ListDataModel<Movimentacao> listaModelmovimentacoes;
	private List<Movimentacao> listaFiltradaModelMovimentacoes;
	private List<Movimentacao> listaMovimentacoes;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ListDataModel<Movimentacao> getListaModelmovimentacoes() {
		return listaModelmovimentacoes;
	}

	public void setListaModelmovimentacoes(ListDataModel<Movimentacao> listaModelmovimentacoes) {
		this.listaModelmovimentacoes = listaModelmovimentacoes;
	}
	
	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	public List<Movimentacao> getListaFiltradaModelMovimentacoes() {
		return listaFiltradaModelMovimentacoes;
	}

	public void setListaFiltradaModelMovimentacaos(List<Movimentacao> listaFiltradaModelMovimentacoes) {
		this.listaFiltradaModelMovimentacoes = listaFiltradaModelMovimentacoes;
	}

	
	//Mtodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.cliente = new Cliente();
		this.fornecedor = new Fornecedor();
		this.item = new Item(this.cliente,this.fornecedor);
		this.armazem =  new Armazem();
		this.movimentacao = new Movimentacao(this.armazem,this.item);
	}
	
	public void Insert() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			MovimentacaoDAO dao = new MovimentacaoDAO(conexao);
			
			dao.Inserir(this.movimentacao);
					
			this.movimentacao = new Movimentacao();
			
			this.listaMovimentacoes = dao.listarTodos();
			
			this.listaModelmovimentacoes = new ListDataModel<>(this.listaMovimentacoes);
			
			JSFUtil.adicionarMensagemSucesso("Movimentacao cadastrado com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um movimentacao" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.movimentacao = this.listaModelmovimentacoes.getRowData();
	}
	
	public void Delete() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			MovimentacaoDAO dao = new MovimentacaoDAO(conexao);
			
			dao.Excluir(this.movimentacao.getId());
					
			this.movimentacao = new Movimentacao();
			
			this.listaMovimentacoes = dao.listarTodos();
			this.listaModelmovimentacoes = new ListDataModel<>(this.listaMovimentacoes);
			
			JSFUtil.adicionarMensagemSucesso("Movimentacao deletada com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.movimentacao = this.listaModelmovimentacoes.getRowData();
	}
	
	public void Update() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			MovimentacaoDAO dao = new MovimentacaoDAO(conexao);
			
			dao.Atualizar(this.movimentacao);
					
			this.movimentacao = new Movimentacao();
			
			this.listaMovimentacoes = dao.listarTodos();
			this.listaModelmovimentacoes = new ListDataModel<>(this.listaMovimentacoes);
			
			JSFUtil.adicionarMensagemSucesso("Movimentacao atualizada com sucesso!");
			
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
			
			MovimentacaoDAO dao = new MovimentacaoDAO(con);
				
			this.listaMovimentacoes = dao.listarTodos();
			this.listaModelmovimentacoes = new ListDataModel<>(this.listaMovimentacoes);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










