package punto2;
import metodos.Colorear;
import java.util.concurrent.Semaphore;

public class Semaforo extends Thread{	//extends: es para la herencia de los hilos en java
//atributos del semaforo:
	private String nombre;
	private int espera;
	//private static final int permisos; // Permisos del semáforo
	
	private static Semaphore semaforo = new Semaphore(3);
//	private static Semaphore nombre_s = new Semaphore(permisos);	
	
	public Semaforo(String nombre_semaforo, int espera) {
		this.nombre = nombre_semaforo;
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
			Colorear.negro(nombre+" - INTERRUMPIDO.");
				Thread.currentThread().interrupt();
		}	
		finally {
			semaforo.release();
		}
		
	}//Run();
}//Semaforo
