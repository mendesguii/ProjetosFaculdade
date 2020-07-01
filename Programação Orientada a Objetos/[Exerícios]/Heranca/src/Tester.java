
public class Tester {

	public static void main(String[] args) {
		// Objetos instanciados
		Visitante v1 = new Visitante();
		Aluno a1 = new Aluno();
		Bolsista b1 = new Bolsista();
		Professor p1 = new Professor();
		Tecnico t1 = new Tecnico();
		
		//Inserção de dados
		System.out.println("===== Log de Ações =====");
		//Visitante
		v1.setNome("Visitante 1");
		v1.setIdade(20);
		v1.setSexo("M");
		
		// Aluno
		a1.setCurso("Sistemas de Info.");
		a1.setIdade(23);
		a1.setMatricula(100);
		a1.setNome("Weverson");
		a1.setSexo("F");
		a1.PagarMensalidade();
		
		// Bolsista
		b1.setBolsa(900);
		b1.setCurso("Historia");
		b1.setIdade(19);
		b1.setMatricula(200);
		b1.setNome("Varelia");
		b1.setSexo("M");
		b1.PagarMensalidade();
		
		// Professor
		p1.setEspecialidade("Matemática financeira");
		p1.setIdade(65);
		p1.setNome("Varlei");
		p1.setSalario(1500);
		p1.setSexo("M");
		p1.receberAumento();
		
		// Técnico
		t1.setCurso("Sistemas de Info");
		t1.setIdade(21);
		t1.setMatricula(604);
		t1.setNome("Cleber");
		t1.setSexo("M");
		t1.Praticar();
		t1.PagarMensalidade();
		t1.setRegistroProfissional("Experiência com programação");
		
		
	}

}
