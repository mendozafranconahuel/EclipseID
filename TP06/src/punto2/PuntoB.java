package punto2;
import java.util.concurrent.Semaphore;
import metodos.Colorear;
import metodos.Metodo;
/*
Implemente, mediante Hilos heredando de Thread, un programa que emplee un semáforo
general inicializado en 3 y simplemente cada hilo duerma por 5”. 

Debe indicar el momento antes de empezar a dormir y cuando deja de dormir. Observar el orden de
ejecución de los hilos pasando por parámetro el nombre del mismo. Debe lanzar 10 hilos.
*/
class SemaforoParametro extends Thread {
	private String nombre;
	private int espera;
	private Semaphore semaforo;

	public SemaforoParametro(String nombre, Semaphore semaforo, int espera) {
		this.semaforo = semaforo;
		this.nombre = nombre;
		this.espera = espera;
    }
    
    @Override
	public void run() {
		try {
			Colorear.azul(nombre+" - SOLICITANDO PERMISO.");
				semaforo.acquire();		// Adquirir permiso del semáforo
            
            Colorear.verde(nombre+" - OBTUVO PERMISO. (Espera de "+espera/1000+" segundos)");
            	Thread.sleep(espera);	//Simular trabajo durmiendo 5 segundos
            
            Colorear.rojo(nombre+" - FIN DE PERMISO.");
		}
		catch(InterruptedException e) {
			System.out.println(nombre+" - INTERRUMPIDO.");
				Thread.currentThread().interrupt();
		}	
		finally {
			semaforo.release();
		}
		
    }//run

//b. En el segundo intento defina el semáforo en el main y pase por parámetro a la clase “Semaforo” dicho objeto de control.

	public class PuntoB {
	    public static void main(String[] args) {
	        System.out.println("B. SEMAFORO POR PARAMETRO");
	        int hilos = Metodo.pedirEntero("\n > NUMERO DE HILOS: ");
	        int espera = Metodo.pedirEntero(" > TIEMPO DE ESPERA: ");
	        	espera = espera * 1000;
	        int permisos = Metodo.pedirEntero(" > PERMISOS DEL SEMAFORO: ");
	        
	        Semaphore semaforo = new Semaphore(permisos);
	        
	        // Crear y lanzar 10 hilos
	        for (int i = 1; i <= hilos; i++) {
	            SemaforoParametro hilo = new SemaforoParametro("HILO "+i, semaforo, espera);
	            hilo.start();
	        } 
	    }
	}//PuntoB
}//SemaforoParametro