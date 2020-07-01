
public class Partida_Tester {

	public static void main(String[] args) {
		Time t1 = new Time();
		Time t2 = new Time();
		Partida p1 = new Partida();
		
		t1.setNome("Flamengo");
		t2.setNome("Vasco");
		
		p1.setTimeLocal(t1);
		p1.setTimeVisitante(t2);
		
		p1.iniciarPartida();
		p1.mostrarResultado();
		p1.finalizarPartida();
		
		t1.listar();
		t2.listar();
		
		p1.iniciarPartida();
		p1.mostrarResultado();
		p1.finalizarPartida();
		
		t1.listar();
		t2.listar();
		
	}

}
