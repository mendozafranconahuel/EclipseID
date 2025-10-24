package megaLimpio;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Lavadero {
	private static Semaphore galpon = new Semaphore(20);
	private static Semaphore lavaderos = new Semaphore(4);
	private Random random = new Random();
	private static int saldo = 0;

	public void ingresarGalpon(String auto) {
		try {
			if (galpon.tryAcquire()) {
				System.out.println(auto + " ingreso al galpon!!!");
			} else {
				System.out.println(auto + " está esperando ----------------");
				galpon.acquire();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void lavar(String auto) {
		try {
			lavaderos.acquire();
			int tiempo = random.nextInt(151) + 150;
			System.out.println(auto + "  - - Se está lavando!!!");
			Thread.sleep(tiempo);
			System.out.println(auto + " Termino de lavarse y salio del galpon!!!");
			saldo += 500;
			System.out.println("Saldo actual -> " + saldo);
			galpon.release();
			lavaderos.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		int contador = 1;
		int tiempo = 0;
		Random r = new Random();
		while (true) {
			tiempo = r.nextInt(51) + 50;
			Auto auto = new Auto(contador++);
			auto.start();
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
