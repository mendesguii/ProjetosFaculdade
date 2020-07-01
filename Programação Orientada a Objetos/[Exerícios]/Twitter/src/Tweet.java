import java.util.Date;
import java.util.Scanner;

public class Tweet {
	private String texto;
	private Date horario;
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public void  Tweetar(Usuario a1) {
		String teste = "y";
		while(teste.equals("y"))
		{
			if(a1.isLogado())
			{
				Date date = new Date(); 
				this.horario = date;
				
				Scanner dados = new Scanner(System.in);
				System.out.print("Digite o tweet: ");
				String tweet = dados.nextLine();
				
				if(tweet.length() >= 140)
				{
					System.out.println("~ Ultrapassou o limite de caracteres! ~");
				}
				else
				{
					Tweet t2 = new Tweet();
					t2.setTexto(tweet);
					t2.setHorario(horario);
					//this.texto = tweet;
					a1.adicionarTweet(t2);
					System.out.println("~ Tweet postado! ~");
					System.out.print("==== Deseja postar mais ? (y/n): ");
					teste = dados.next();
					
				}
			}
			else
			{
				System.out.println("~ Precisa estar logado para postar ~");
				
			}
		
		}
		System.out.println("\r\n");
		
	}
	
	
}
