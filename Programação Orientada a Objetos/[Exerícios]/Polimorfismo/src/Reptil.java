
public class Reptil extends Animal{
	private String corEscama;
	
	@Override
	public void locomover() {
		System.out.println("Andando como um reptil");
		
	}

	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}

	@Override
	public void alimentar() {
		System.out.println("Se alimetando como um reptil");
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Barulho de reptil");
		
	}
	
	

}
