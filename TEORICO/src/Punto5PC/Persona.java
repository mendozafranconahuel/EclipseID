package Punto5PC;
import java.util.concurrent.Semaphore;

public class Persona extends Thread {

	static public Semaphore sem = new Semaphore(0);
	
		int numero;
		public Persona(int Numero) {
			this.numero = Numero;
		}
	
	public void run() {
	
		try {
			sem.acquire();
			System.out.println("Persona ("+ numero +") Adquirí el recurso");
		} 
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finally {
			sem.release();
			System.out.println("Persona ("+ numero +") Liberé el recurso");
		}
	}
}