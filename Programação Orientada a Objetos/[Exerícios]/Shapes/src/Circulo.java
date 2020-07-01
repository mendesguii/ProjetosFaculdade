
public class Circulo implements IShape,IShow{
	
	private float raio;
	private float pi = (float) 3.14;
	
	public float getRaio() {
		return raio;
	}


	public void setRaio(float raio) {
		this.raio = raio;
	}


	public Circulo(float raio)
	{
		setRaio(raio);
	}
	
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return this.pi*(this.raio*this.raio);
	}

	@Override
	public float getPerimetro() {
		// TODO Auto-generated method stub
		return 2*this.pi*this.raio;
	}

	@Override
	public void Imprimir() {
		System.out.println("Area: "+getArea());
		System.out.println("Perimetro: "+getPerimetro());
		
	}

}
