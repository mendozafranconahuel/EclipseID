package punto4;

public abstract class Forma { 
	protected String nombreForma;

//	CONSTRUCTORES
	
	public Forma() {
	}
	
	public Forma(String nombreForma) {
		this.nombreForma = nombreForma;
	}
	
	public abstract double area();

	public abstract double perimetro();
}