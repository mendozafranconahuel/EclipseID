package aeropuerto;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Aeropuerto {
	private static Semaphore t3 = new Semaphore(4);
	private static Semaphore t4 = new Semaphore(5);
	private static Semaphore t5 = new Semaphore(3);
	private Random r = new Random();

	public void checkIn(int pasajero, int terminal) throws InterruptedException {
		int tiempoEspera = r.nextInt(101) + 180;
		if (terminal == 3) {
			t3.acquire();
			System.out.println("PASAJERO " + pasajero + " ESTA realizando Check-IN en T" + terminal);
			Thread.sleep(tiempoEspera);
			System.out.println("PASAJERO " + pasajero + " finalizo Check-IN en T" + terminal);
			t3.release();

		} else if (terminal == 4) {
			t4.acquire();
			System.out.println("PASAJERO " + pasajero + " ESTA realizando Check-IN en T" + terminal);
			Thread.sleep(tiempoEspera);
			System.out.println("PASAJERO " + pasajero + " finalizo Check-IN en T" + terminal);
			t4.release();

		} else {
			t5.acquire();
			System.out.println("PASAJERO " + pasajero + " ESTA realizando Check-IN en T" + terminal);
			Thread.sleep(tiempoEspera);
			System.out.println("PASAJERO " + pasajero + " finalizo Check-IN en T" + terminal);
			t5.release();
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		while (true) {
			try {
				Taxi taxi = new Taxi();
				taxi.start();
				int tiempo = random.nextInt(61) + 120;
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
