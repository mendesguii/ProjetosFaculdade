import java.util.Date;

public class Partida implements IPartida
{
	
	private Time timeVisitante;
	private Time timeLocal;
	
	
	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Time getTimeLocal() {
		return timeLocal;
	}

	public void setTimeLocal(Time timeLocal) {
		this.timeLocal = timeLocal;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	private int scoreVisitante;
	private int scoreLocal;
	private Date dataPartida;
	
	public int Random_Placar(int min, int max)
	{
		int numrandom = (int)((Math.random()*((max-min)+1))+min);
		return numrandom;
	}
	
	@Override
	public void iniciarPartida() {
		System.out.println("Partida Iniciando !!");
		scoreVisitante = Random_Placar(0,10);
		scoreLocal = Random_Placar(0,10);
		
	}

	@Override
	public void mostrarResultado() {
		System.out.println(timeLocal.getNome()+" "+scoreLocal+ " X "+scoreVisitante+" "+timeVisitante.getNome());
	}

	@Override
	public void finalizarPartida() {
		if(scoreLocal > scoreVisitante)
		{
			// Vitoria time local
			timeLocal.setQtdVitorias(timeLocal.getQtdVitorias() + 1); 
			timeLocal.setQtdPontos(timeLocal.getQtdPontos() + 3);
			// Derrota time visitante
			timeVisitante.setQtdDerrotas(timeVisitante.getQtdDerrotas() + 1);
		}
		else if (scoreLocal == scoreVisitante)
		{	// Time Local Empate
			timeLocal.setQtdEmpates(timeLocal.getQtdEmpates()+1);
			timeLocal.setQtdPontos(timeLocal.getQtdPontos()+1);
			// Time Visitante Empate
			timeVisitante.setQtdEmpates(timeVisitante.getQtdEmpates()+1);
			timeVisitante.setQtdPontos(timeVisitante.getQtdPontos()+1);
		}
		else
		{
			// Vitoria time Visitante
			timeVisitante.setQtdVitorias(timeVisitante.getQtdVitorias() + 1);
			timeVisitante.setQtdPontos(timeVisitante.getQtdPontos() +3);
			// Derrota time Local
			timeLocal.setQtdDerrotas(timeLocal.getQtdDerrotas() + 1);
		}
	}
	
	
	
	
	
	
	
	
}
