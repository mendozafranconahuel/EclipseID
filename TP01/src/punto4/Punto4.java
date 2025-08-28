package punto4;
import metodos.Metodo;

public class Punto4 {
	public static void main (String [] arg) {
		//Cuadrilatero c = new Cuadrilatero("uno",5,6);
		Cuadrilatero c = null;
		double l1 = 0, l2 = 0;
		
		l1 = Metodo.dimencion("> LADO 1: ", 0);
		l2 = Metodo.dimencion("> LADO 2: ", 0);

		if (l1 > 0 || l2 >0 ) {
			if(l1 == l2) {
				c = new Cuadrilatero ("Cuadrado",l1,l2);
			}
			else{
				c = new Cuadrilatero ("Resctangulo",l1,l2);	
			}
		}
	System.out.println("\n\n- NOMBRE: "+c.nombreForma);
	System.out.println("- AREA: "+c.area());
	System.out.println("- PERIMETRO: "+c.perimetro());
	}
}//punto4