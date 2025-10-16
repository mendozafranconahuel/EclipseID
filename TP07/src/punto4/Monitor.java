package punto4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Monitor {
	private Semaphore semaforo;
	private Random r;

	public Monitor() {
		this.semaforo = new Semaphore(0);
		this.r = new Random();
	}

	public void esperar() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void indicar() {
		semaforo.release();
	}

	public int tiempoEjecucion() {
		return r.nextInt(10) + 1;
	}
}
