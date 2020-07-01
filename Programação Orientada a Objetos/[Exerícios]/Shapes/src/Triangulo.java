
public class Triangulo implements IShape,IShow {

	private float a;
	private float b;
	private float c;
	
	public Triangulo(float a, float b ,float c)
	{
		setA(a);
		setB(b);
		setC(c);
	}
	
	@Override
	public void Imprimir() {
		System.out.println("Area "+getArea());
		System.out.println("Peri. : "+getPerimetro());
	}

	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return (this.a*this.b*this.c)/2;
	}

	@Override
	public float getPerimetro() {
		// TODO Auto-generated method stub
		return (this.a+this.b+this.c);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}

	

}
