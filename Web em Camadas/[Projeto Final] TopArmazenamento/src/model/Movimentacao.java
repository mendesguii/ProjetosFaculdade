package model;

public class Movimentacao {

	private int id;
	private Armazem armazem;
	private Item item;
	private float quantidade;
	private float preco;
	
	public Movimentacao(int id, Armazem armazem, Item item, float quantidade, float preco) {
		super();
		this.id = id;
		this.armazem = armazem;
		this.item = item;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public Movimentacao() {}
	
	public Movimentacao(Armazem armazem, Item item) 
	{
		this.armazem = armazem;
		this.item = item;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Armazem getArmazem() {
		return armazem;
	}
	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", armazem=" + armazem + ", item=" + item + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
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
		Movimentacao other = (Movimentacao) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
