import java.util.InputMismatchException;
import java.util.Scanner;

public class Retangulo implements IShape,IShow{

	private float base;
	private float alt;
	
	public Retangulo(float base, float alt)
	{
		setBase(base);
		setAlt(alt);
	}
	
	@Override
	public float getArea() {
		
		return (this.base*this.alt);
	}

	@Override
	public float getPerimetro() {
		
		return (this.base*2)+(this.alt*2);
	}
	
	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getAlt() {
		return alt;
	}

	public void setAlt(float alt) {
		this.alt = alt;
	}

	@Override
	public void Imprimir() {
		System.out.println("Perimetro "+getPerimetro());
		System.out.println("Base "+getArea());	
	}
	public void calcular()
	{
		float perim1,area1;
		try{
			System.out.println("Entre com a base: ");
			Scanner a = new Scanner(System.in);
			base = a.nextInt();
			System.out.println("Entre com a Altura: ");
			alt = a.nextInt();
			area1 = base * alt;
			perim1 = base+alt+base+alt;
			System.out.println("Area: " +area1);	
			System.out.println("Perim.: " +perim1);
		}
		catch (InputMismatchException e)
		{
			System.out.println("~ Tipo errado de info ~");
			calcular();
		}
		
		
	}

	

}
