package Punto3.PC;
import java.util.concurrent.Semaphore;

public class Auto extends Thread{
	Semaphore sem = new Semaphore(3);
	
	public void run() {
		try {
			sem.acquire();
			System.out.println("Me duermo");
			Thread.sleep(1000);
			System.out.println("Me despierto");
		} 
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		//sem.release();
	}
}