package punto2;
import metodos.Metodo;

/*
Implemente, mediante Hilos heredando de Thread, un programa que emplee un semáforo general inicializado en 3 y simplemente cada hilo duerma por 5”. 

Debe indicar el momento antes de empezar a dormir y cuando deja de dormir. Observar el orden de ejecución de los hilos pasando por parámetro el nombre del mismo. Debe lanzar 10 hilos.
*/

//a. En el primer intento genere una clase llamada “Semaforo” y defina e inicialice el semáforo de control dentro de dicha clase.

public class PuntoA {
	public static void main(String[] args) {
        
		System.out.println("\n A. SEMAFORO POR CLASES");
        
		int hilos = Metodo.pedirEntero("\n > NUMERO DE HILOS: ");	
        int espera = Metodo.pedirEntero(" > TIEMPO DE ESPERA: ");
    		espera = espera * 1000;
    	//int permisos = Metodo.pedirEntero(" > PERMISOS DEL SEMAFORO: ");
		
    	System.out.println("\n--> CORRIENDO "+hilos+" HILOS: \n"); 
		
    	for (int i = 1; i <= hilos; i++) {
	    		Semaforo hilo = new Semaforo("HILO "+i, espera);
	    		hilo.start();
	    }
    }
}