package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.model.ListDataModel;

import dao.CriadorConexao;
import dao.ItemDAO;
import model.Cliente;
import model.Fornecedor;
import model.Item;
import util.JSFUtil;

public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public ItemBean() {
		this.item	= new Item();
	}
	
	//Atributos
	private Item item;
	private Cliente cliente;
	private Fornecedor fornecedor;
	private ListDataModel<Item> listaModelitens;
	private List<Item> listaFiltradaModelItens;
	private List<Item> listaItens;
	
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

	public ListDataModel<Item> getListaModelitens() {
		return listaModelitens;
	}

	public void setListaModelitens(ListDataModel<Item> listaModelitens) {
		this.listaModelitens = listaModelitens;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<Item> getListaFiltradaModelItens() {
		return listaFiltradaModelItens;
	}

	public void setListaFiltradaModelItems(List<Item> listaFiltradaModelItens) {
		this.listaFiltradaModelItens = listaFiltradaModelItens;
	}

	
	//Mtodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.cliente = new Cliente();
		this.fornecedor = new Fornecedor();
		this.item = new Item(this.cliente,this.fornecedor);
	}
	
	public void Insert() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ItemDAO dao = new ItemDAO(conexao);
			
			dao.Inserir(this.item);
					
			this.item = new Item();
			
			this.listaItens = dao.listarTodos();
			
			this.listaModelitens = new ListDataModel<>(this.listaItens);
			
			JSFUtil.adicionarMensagemSucesso("Item cadastrado com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um item" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.item = this.listaModelitens.getRowData();
	}
	
	public void Delete() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ItemDAO dao = new ItemDAO(conexao);
			
			dao.Excluir(this.item.getId());
					
			this.item = new Item();
			
			this.listaItens = dao.listarTodos();
			this.listaModelitens = new ListDataModel<>(this.listaItens);
			
			JSFUtil.adicionarMensagemSucesso("Item deletada com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.item = this.listaModelitens.getRowData();
	}
	
	public void Update() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ItemDAO dao = new ItemDAO(conexao);
			
			dao.Atualizar(this.item);
					
			this.item = new Item();
			
			this.listaItens = dao.listarTodos();
			this.listaModelitens = new ListDataModel<>(this.listaItens);
			
			JSFUtil.adicionarMensagemSucesso("Item atualizada com sucesso!");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void init() {
		
		try {
			CriadorConexao fab = new CriadorConexao();
			Connection con = fab.fazerConexao();
			
			ItemDAO dao = new ItemDAO(con);
				
			this.listaItens = dao.listarTodos();
			this.listaModelitens = new ListDataModel<>(this.listaItens);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










