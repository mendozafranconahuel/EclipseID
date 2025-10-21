package punto4;
import java.util.Scanner;
import metodos.Metodo;

/*
Debe solicitar el ingreso de una frase por la entrada de teclado, a continuación (una vez
apretado Enter) deberá imprimir 10 veces dicha frase pero carácter por carácter
empleando hilos. 
*/

public class Principal {
	public static void main(String[] args) {
		String frase = Metodo.pedirCadena("\n > INGRESE UNA FRASE: ");
		frase = Metodo.todoMatuscaulas(frase);
		
		System.out.println(frase);
	}
}
