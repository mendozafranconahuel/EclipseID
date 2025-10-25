package PDF.PUNTO1;

/*
Deseamos saber que tan buena es nuestra máquina de juegos de dados, 
por ello para testearla se ejecutará lo siguiente cada 2”. 

Se lanzarán 6 dados normales y se deberá imprimir por pantalla 

si la suma de los dados es par o impar (mostrando la sucesión de dados),

adicionalmente, si la ejecución/tirada/lanzamiento produjo una escalera con los 6 números 
(1, 2, 3, 4, 5, 6 en cualquier orden) mostrar también en letras mayúsculas “SE HA PRODUCIDO UNA ESCALERA!!!”.

Puntos a evaluar:
	a. Compilación sin errores.
	b. Generación del tiempo de testeo.
	c. Mostrar la sucesión de dados, si la suma es par o impar y el mensaje si se produce una escalera. 
 
*/

import java.util.*;

public class Principal {
    
	    public static String resultadoSuma(int suma) {
	        if (suma % 2 == 0) { 
	            return "PAR";
	        } else { 
	            return "IMPAR";
	        }
	    }
/////////////////////////////////////////////////////////////////////////////////////////////////////    
	    public static boolean esEscalera(ArrayList<Integer> valores) {
	        // Verificar si tenemos todos los números del 1 al 6
	        if (valores.size() != 6) return false;
	        
	        boolean[] numeros = new boolean[7]; // índices 1-6
	        for (int valor : valores) {
	            if (valor >= 1 && valor <= 6) {
	                numeros[valor] = true;
	            }
	        }
	        
	        // Verificar que todos los números del 1 al 6 estén presentes
	        for (int i = 1; i <= 6; i++) {
	            if (!numeros[i]) {
	                return false;
	            }
	        }
	        return true;
	    }
/////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    public static void main(String[] args) {
        // Testeo cada 2 segundos
        int numLanzamiento=0;
    	while (true) {
            numLanzamiento++;
    		System.out.println("\n### LANZAMIENTO "+numLanzamiento+" ###");
            
    		Lanzamiento[] dados = new Lanzamiento[6];
	        
    			for (int i = 0; i < 6; i++) {
	                dados[i] = new Lanzamiento(i+1);
	                dados[i].start();
	            }
            
	            for (int i = 0; i < 6; i++) {
	                try {
	                    dados[i].join();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
            
            // Recoger resultados
            ArrayList<Integer> valores = new ArrayList<>();
            int suma = 0;
            
            for (int i = 0; i < 6; i++) {
                valores.add(dados[i].getValor());
                suma += dados[i].getValor();
            }
            
            System.out.println("\n - Sucesión de dados: " + valores);
            System.out.println(" - Suma: " + suma + " (" + resultadoSuma(suma) + ")");
            
            if (suma == 21 && esEscalera(valores) == true) {
                System.out.println(" - SE HA PRODUCIDO UNA ESCALERA!!!");
                break;
            }
            System.out.println("### FIN DEL LANZAMIENTO ###\n");   
        }
    }
}
