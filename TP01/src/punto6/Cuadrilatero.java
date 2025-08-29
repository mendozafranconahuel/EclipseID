package punto6;
public class Cuadrilatero implements Forma{
	private double lado1 = 0;
	private double lado2 = 0;
	public Cuadrilatero() {}
	public Cuadrilatero(double lado1, double lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	@Override
	public double area() {
		return lado1 * lado2;
	}
	@Override
	public double perimetro() {
		return 2 * (lado1 + lado2);
	}
}