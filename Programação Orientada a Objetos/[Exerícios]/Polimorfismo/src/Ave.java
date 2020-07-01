
public class Ave extends Animal {
	private String corPena;
	public void fazerNinho()
	{
		System.out.println("Fazendo o ninho do amor");
	}
	@Override
	public void locomover() {
		System.out.println("Voar");
		
	}
	@Override
	public void alimentar() {
		System.out.println("Comida de passaro");
		
	}
	@Override
	public void emitirSom() {
		System.out.println("Barulho de passaro");
		
	}
	public String getCorPena() {
		return corPena;
	}
	public void setCorPena(String corPena) {
		this.corPena = corPena;
	}
	

}
