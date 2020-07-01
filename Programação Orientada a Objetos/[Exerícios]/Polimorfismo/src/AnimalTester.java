
public class AnimalTester {

	public static void main(String[] args) {
		// Instanciando Classes
		Ave a1 = new Ave();
		Mamifero m1 = new Mamifero();
		Peixe p1 = new Peixe();
		Reptil r1 = new Reptil();
		
		
		// Metodos
		System.out.println("=-=-=-=-=-=-=-=-=-=--=");
		a1.setCorPena("Rosa");
		a1.setIdade(24);
		a1.setMembros(4);
		a1.setPeso(6);
		
		a1.fazerNinho();
		
		a1.alimentar();
		a1.emitirSom();
		a1.locomover();
		System.out.println("=-=-=-=-=-=-=-=-=-=--=");
		m1.setIdade(20);
		m1.setMembros(4);
		m1.setPeso(64);
		m1.setCorPelo("verde");
		
		m1.alimentar();
		m1.emitirSom();
		m1.locomover();
		System.out.println("=-=-=-=-=-=-=-=-=-=--=");
		p1.setCorEscama("Azul");
		p1.setMembros(3);
		p1.setIdade(2);
		p1.setPeso(1);
		
		p1.soltarBolha();
		p1.alimentar();
		p1.emitirSom();
		p1.locomover();
		System.out.println("=-=-=-=-=-=-=-=-=-=--=");
		r1.setIdade(4);
		r1.setMembros(5);
		r1.setPeso(10);
		r1.setCorEscama("Marrom");
		
		r1.alimentar();
		r1.emitirSom();
		r1.locomover();
		System.out.println("=-=-=-=-=-=-=-=-=-=--=");
		
		
		
		

	}

}
