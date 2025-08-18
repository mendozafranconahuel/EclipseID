package punto4;

public class Cuadrilatero extends Forma {
	double L1 = 0, L2 = 0;
	
	public Cuadrilatero() {}
	
	public Cuadrilatero(String nombre, double L1, double L2) {
		this.nombreForma = nombre;
		this.L1 = L1;
		this.L2 = L2;	
	}
// static static
	public double area() {
		double calculo = L1 * L2; 
		return calculo;
	}

	public double perimetro() {
		double calculo = 2 * (L1 + L2);
		return calculo;
	}
}