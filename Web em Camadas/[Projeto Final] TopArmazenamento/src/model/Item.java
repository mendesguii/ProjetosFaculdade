package model;

public class Item {
	
	private int id;
	private String partNumber;
	private String descricao;
	private String unidadeDeMedida;
	private Cliente cliente;
	private Fornecedor fornecedor;
	
	public Item(int id, String partNumber, String descricao, String unidadeDeMedida, Cliente cliente,
			Fornecedor fornecedor) {
		super();
		this.id = id;
		this.partNumber = partNumber;
		this.descricao = descricao;
		this.unidadeDeMedida = unidadeDeMedida;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
	
	public Item() {}
	
	public Item(Cliente cliente,
			Fornecedor fornecedor)
	{
		
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

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

	@Override
	public String toString() {
		return "Item [id=" + id + ", partNumber=" + partNumber + ", descricao=" + descricao + ", unidadeDeMedida="
				+ unidadeDeMedida + ", cliente=" + cliente + ", fornecedor=" + fornecedor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
