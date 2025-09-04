package punto7;

import java.util.concurrent.Semaphore;

public class Punto7 {
	static Semaphore semaforo1 = new Semaphore(1);
	static Semaphore semaforo2 = new Semaphore(0);
	static Semaphore semaforo3 = new Semaphore(0);
	static Semaphore semaforo4 = new Semaphore(0);

	public static void main(String[] arg) {
		Hilo1 hilo1 = new Hilo1();
		Hilo2 hilo2 = new Hilo2();
		Hilo3 hilo3 = new Hilo3();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
	
	static class Hilo1 extends Thread {
		public void run() {
			try {
				semaforo1.acquire();
				System.out.print('R');
				semaforo2.release();
				semaforo4.acquire();
				System.out.print(" OK ");
				semaforo4.release();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class Hilo2 extends Thread {
		public void run() {
			try {
				semaforo2.acquire();
				System.out.print('I');
				semaforo3.release();
				semaforo4.acquire();
				System.out.print(" OK ");
				semaforo4.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class Hilo3 extends Thread {
		public void run() {
			try {
				semaforo3.acquire();
				System.out.print('O');
				semaforo4.release();
				semaforo4.acquire();
				System.out.print(" OK ");
				semaforo4.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
