import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String usuario;
	private String nome;
	private ArrayList<Tweet> tweets;
	private boolean logado;
	
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Usuario(){
		tweets = new ArrayList<Tweet>();
	}
		
	public void Login() {
		Scanner dados = new Scanner(System.in);
		System.out.print("Digite o Login: ");
		String login = dados.next();
		System.out.print("Digite a Senha: ");
		String senha = dados.next();
		if(senha.equals("poo"))
		{
			logado = true;
			System.out.println("~ Login efetuado com sucesso como "+nome+"! ~");
			System.out.println("\r\n");
		}
		else
		{
			System.out.println("~ Senha incorreta! ~");
			System.out.print("- Tenta novamente ? - (y/n): ");
			String confirmacao = dados.next();
			if(confirmacao.equals("y"))
			{
				System.out.println("\r\n");
				Login();
			}
		}
	}
	
	public void Logout()
	{
		if(logado)
		{
			logado=false;
			System.out.println("~ Deslogado! ~");
		}
		else {
			System.out.println("~ Você não está logado! ~");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
	public void adicionarTweet(Tweet novoTweet){
		if (logado)
		{
			tweets.add(novoTweet);
			//System.out.println("\r\n");
		}
		else
		{
			System.out.println("~ Para postar e necessario logar ~");
			//System.out.println("\r\n");
		}
	}
	public void imprimirTweet(){
		for(int i = 0 ; i < tweets.size() ; i++){
			Tweet t1;
			t1 = tweets.get(i);
			System.out.println("~ Tweet #"+i+" "+ t1.getHorario()+" ~");
			System.out.println("Tweet:"+t1.getTexto());
			System.out.println("=======================================");
			//System.out.println("\r\n");
		}
		
	}

	

}
