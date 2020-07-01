public class TestTweet {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("Jose");
		usuario.setUsuario("@josebolado");
		
		usuario.Login();
		
		Tweet t1 = new Tweet();
		t1.Tweetar(usuario);
		usuario.imprimirTweet();
		usuario.Logout();
		
	}

}
