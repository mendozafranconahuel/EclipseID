package aeropuerto;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Taxi extends Thread {
	private Aeropuerto m = new Aeropuerto();
	private Random r = new Random();
	private static int aux = 1;
	private Semaphore sem = new Semaphore(1);

	@Override
	public void run() {
		try {
			int terminal = r.nextInt(3) + 3;
			int pasajerosGenerados = r.nextInt(4) + 1;
			System.out.println(" ----------  LLegaron " + pasajerosGenerados + " a la T" + terminal);
			Pasajero[] pasajeros = new Pasajero[pasajerosGenerados];
			sem.acquire();
			for (int i = 0; i < pasajerosGenerados; i++) {
				pasajeros[i] = new Pasajero(i + aux, terminal);
				pasajeros[i].start();
			}
			aux += pasajerosGenerados;
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
