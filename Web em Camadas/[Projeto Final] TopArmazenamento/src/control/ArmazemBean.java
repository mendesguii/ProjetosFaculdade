package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.CriadorConexao;
import dao.ArmazemDAO;
import model.Armazem;
import util.JSFUtil;

@ManagedBean(name = "armazemBean")
@ViewScoped
public class ArmazemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//Construtores
	public ArmazemBean() {
		this.armazem	= new Armazem();
	}
	
	//Atributos
	private Armazem armazem;
	private ListDataModel<Armazem> listaModelarmazens;
	private List<Armazem> listaFiltradaModelArmazens;
	private List<Armazem> listaArmazens;
	
	//M�todos de acesso
	public ListDataModel<Armazem> getListaModelarmazens() {
		return listaModelarmazens;
	}

	public void setListaModelarmazens(ListDataModel<Armazem> listaModelarmazens) {
		this.listaModelarmazens = listaModelarmazens;
	}
	
	public Armazem getArmazem() {
		return armazem;
	}

	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}
	
	public List<Armazem> getListaFiltradaModelArmazens() {
		return listaFiltradaModelArmazens;
	}

	public void setListaFiltradaModelArmazems(List<Armazem> listaFiltradaModelArmazens) {
		this.listaFiltradaModelArmazens = listaFiltradaModelArmazens;
	}

	
	//Mtodos de Acesso ao Banco de Dados
	
	public void PrepararNovo() {
		this.armazem = new Armazem();
	}
	
	public void Insert() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ArmazemDAO dao = new ArmazemDAO(conexao);
			
			dao.Inserir(this.armazem);
					
			this.armazem = new Armazem();
			
			this.listaArmazens = dao.listarTodos();
			this.listaModelarmazens = new ListDataModel<>(this.listaArmazens);
			
			JSFUtil.adicionarMensagemSucesso("Armazem cadastrado com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um armazem" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.armazem = this.listaModelarmazens.getRowData();
	}
	
	public void Delete() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ArmazemDAO dao = new ArmazemDAO(conexao);
			
			dao.Excluir(this.armazem.getId());
					
			this.armazem = new Armazem();
			
			this.listaArmazens = dao.listarTodos();
			this.listaModelarmazens = new ListDataModel<>(this.listaArmazens);
			
			JSFUtil.adicionarMensagemSucesso("Armazem deletado com sucesso!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.armazem = this.listaModelarmazens.getRowData();
	}
	
	public void Update() {
		try {
			CriadorConexao fabrica = new CriadorConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ArmazemDAO dao = new ArmazemDAO(conexao);
			
			dao.Atualizar(this.armazem);
					
			this.armazem = new Armazem();
			
			this.listaArmazens = dao.listarTodos();
			this.listaModelarmazens = new ListDataModel<>(this.listaArmazens);
			
			JSFUtil.adicionarMensagemSucesso("Armazem atualizado com sucesso!");
			
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
			
			ArmazemDAO dao = new ArmazemDAO(con);
				
			this.listaArmazens = dao.listarTodos();
			this.listaModelarmazens = new ListDataModel<>(this.listaArmazens);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










