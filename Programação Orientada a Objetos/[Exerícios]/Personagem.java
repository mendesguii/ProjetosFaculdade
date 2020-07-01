public class Personagem {
    String nome;
    int vida;
    int forca;
    int velocidade;
    void Correr()
    {
        if (vida < 30)
        {
            System.out.println("Muito Cansado para correr");
        }
        else
        {
            System.out.println("Correndooooo");
            velocidade++;
        };
    }
    void Atacar()
    {
    if (vida < 30)
        {
            System.out.println("Muito cansado para Atacar");
            vida--;
        }
    else if(forca < 10 )
        {
            System.out.println("Muito fraco para Atacar");
            vida--;
        }
    else
        {
            System.out.println("Esta na hora da destruicao");
            forca--;
        }
    };
    void Descansar()
    {
        System.out.println("Vou dar uma descansada aqui");
        if (forca < 20)
        {
            forca += (forca - 20);
        }
        if (vida < 100)
        {
            vida += (vida - 100);
        }
    };
    
    }