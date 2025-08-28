package punto5;
import metodos.Metodo;

public class Punto5 {
	public static void main (String [] arg) {
		Circulo c;
		double radio = Metodo.dimencion("> INGRESE EL RADIO: ", 0);
		c = new Circulo("Circulo",radio);
		System.out.println("\n\nCALCULOS:"+c.nombreForma);
		System.out.println("- AREA: "+Metodo.redondear(c.area(), 4));
		System.out.println("- PERIMETRO: "+Metodo.redondear(c.perimetro(),4));
	}
}