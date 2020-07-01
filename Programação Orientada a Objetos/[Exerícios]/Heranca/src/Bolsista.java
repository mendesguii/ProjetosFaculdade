
public class Bolsista extends Aluno {
	private int bolsa;
	public void RenovarBolsa() {
		System.out.println("Bolsa Renovada");
	}
	public int getBolsa() {
		return bolsa;
	}
	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	@Override
	public void PagarMensalidade()
	{
		System.out.println("Mensalidade paga do usuário "+ getNome()+ " com a bolsa de R$"+ bolsa);
	}
	
	
}
