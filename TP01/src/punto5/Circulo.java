package punto5;
import metodos.Metodo;
import punto4.Forma;

public class Circulo extends Forma {
	double radio=0;
	
	public Circulo() {}
	
	public Circulo(String nombre, double radio) {
		this.nombreForma = nombre;
		this.radio = radio;	
	}
	
	public double area() {
		double calculo = Math.PI * Math.pow(radio,2);
		return calculo;
	}

	public double perimetro() {
		double calculo = 2 * Math.PI * radio;
		return calculo;
	}
}
