package punto5;
import metodos.Metodo;

/*Al igual que en el punto anterior, cree una clase Circulo que herede de Forma e implemente los métodos area() y perimetro() de un círculo. 
  Desde el main() cree un objeto de tipo Circulo y 
  muestre la ejecución de los métodos area() y perimetro().*/

public class Punto5 {
	public static void main (String [] arg) {
		Circulo c;
		double radio = Metodo.dimencion("> INGRESE EL RADIO: ", 0);
		c = new Circulo("Circulo",radio);
		System.out.println("\n\nCALCULOS:");
		System.out.println("- AREA: "+Metodo.redondear(c.area(), 4)+"\n- PERIMETRO: "+Metodo.redondear(c.perimetro(),4));
	}
}