
public class Peixe extends Animal {
	private String corEscama;
	public String getCorEscama() {
		return corEscama;
	}
	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}
	public void soltarBolha()
	{
		System.out.println("Soltando bolhas.......");
	}
	@Override
	public void locomover() {
		System.out.println("Nadando");
		
	}

	@Override
	public void alimentar() {
		System.out.println("Se alimentado como um peixe");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Barulho de peixe");
		
	}

}
