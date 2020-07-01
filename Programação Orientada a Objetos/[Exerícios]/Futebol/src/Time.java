
public class Time {
	private String nome;
	private int qtdVitorias;
	private int qtdEmpates;
	private int qtdDerrotas;
	private int qtdPontos;
	
	void Time()
	{
		qtdVitorias = 0;
		qtdEmpates  = 0;
		qtdDerrotas = 0;
		qtdPontos  = 0;
	}
	
	public int getQtdPontos() {
		return qtdPontos;
	}
	public void setQtdPontos(int qtdPontos) {
		this.qtdPontos = qtdPontos;
	}
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdVitorias() {
		return qtdVitorias;
	}
	public void setQtdVitorias(int qtdVitorias) {
		this.qtdVitorias = qtdVitorias;
	}
	public int getQtdEmpates() {
		return qtdEmpates;
	}
	public void setQtdEmpates(int qtdEmpates) {
		this.qtdEmpates = qtdEmpates;
	}
	public int getQtdDerrotas() {
		return qtdDerrotas;
	}
	public void setQtdDerrotas(int qtdDerrotas) {
		this.qtdDerrotas = qtdDerrotas;
	}
	
	public void listar()
	{
		System.out.println(" ");
		System.out.println("Time : "+ nome);
		System.out.println("Vitorias: "+ qtdVitorias);
		System.out.println("Empates: "+ qtdEmpates);
		System.out.println("Derrotas: " + qtdDerrotas);
		System.out.println("Pontos: " + qtdPontos);
	}
	
}
