package mrOlimpia;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MrOlimpia {
	private static Semaphore pista1 = new Semaphore(20);
	private static Semaphore pista2 = new Semaphore(10);
	private Random random = new Random();

	public void pista1(int aspirante) {
		try {
			pista1.acquire();
			int tiempo = random.nextInt(201) + 1100;
			System.out.println("Aspirante " + aspirante + " INGRESO a la pista 1");
			Thread.sleep(tiempo);
			System.out.println("Aspirante " + aspirante + " SALIO de la pista 1");
			pista1.release();
			System.out.println("Aspirante " + aspirante + " se dirije al pasillo ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pista2(int aspirante) {
		try {
			pista2.acquire();
			int tiempo = random.nextInt(201) + 600;
			System.out.println("Aspirante " + aspirante + " Pista 2");
			Thread.sleep(tiempo);
			System.out.println("Aspirante " + aspirante + " SALIO de Pista 2");

			pista2.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int listaAspirante = 200;
		Aspirante[] aspirantes = new Aspirante[listaAspirante];
		for (int i = 0; i < listaAspirante; i++) {
			aspirantes[i] = new Aspirante(i + 1);
			aspirantes[i].start();
		}

	}

}
