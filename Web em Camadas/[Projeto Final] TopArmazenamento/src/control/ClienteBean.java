package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.model.ListDataModel;

import dao.CriadorConexao;
import dao.ClienteDAO;
import model.Cliente;
import util.JSFUtil;

public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public ClienteBean() {
		this.cliente	= new Cliente();
	}
	
	//Atributos
	private Cliente cliente;
	private ListDataModel<Cliente> listaModelclientes;
	private List<Cliente> listaFiltradaModelClientes;
	private List<Cliente> listaClientes;
	
	//M�todos de acesso
	public ListDataModel<Cliente> getListaModelclientes() {
		return listaModelclientes;
	}

	public void setListaModelclientes(ListDataModel<Cliente> listaModelclientes) {
		this.listaModelclientes = listaModelclientes;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaFiltradaModelClientes() {
		return listaFiltradaModelClientes;
	}

	public void setListaFiltradaModelClientes(List<Cliente> listaFiltradaModelClientes) {
		this.listaFiltradaModelClientes = listaFiltradaModelClientes;
	}

	
	//Mtodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.cliente = new Cliente();
	}
	
	public void Insert() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Inserir(this.cliente);
					
			this.cliente = new Cliente();
			
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente cadastrado com sucesso!");
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar uma cliente" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.cliente = this.listaModelclientes.getRowData();
	}
	
	public void Delete() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Excluir(this.cliente.getId());
					
			this.cliente = new Cliente();
			
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente deletada com sucesso!");
			conexao.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.cliente = this.listaModelclientes.getRowData();
	}
	
	public void Update() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Atualizar(this.cliente);
					
			this.cliente = new Cliente();
			
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente atualizada com sucesso!");
			conexao.close();
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
			
			ClienteDAO dao = new ClienteDAO(con);
				
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










