
public class Tecnico extends Aluno{
	private String registroProfissional;
	public void Praticar()
	{
		System.out.println("O "+getNome() +" est� praticando!");
	}
	
	public String getRegistroProfissional() {
		return registroProfissional;
	}
	public void setRegistroProfissional(String registroProfissional) {
		this.registroProfissional = registroProfissional;
	}
	
		
}
