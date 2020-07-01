public class MyClass {
    public static void main(String args[]) {
      Personagem Lutador;
      Lutador = new Personagem();
      
      Lutador.nome = "Fredinho";
      Lutador.vida = 31;
      Lutador.forca = 12;
      Lutador.velocidade = 4;
      
      Lutador.Correr();
      for(int i= 0 ; i<5; i++ )
      {
        Lutador.Atacar();
      }
      Lutador.Descansar();
    
      
      
      
    }
}