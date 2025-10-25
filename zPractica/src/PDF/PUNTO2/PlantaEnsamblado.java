package PDF.PUNTO2;

import java.util.concurrent.Semaphore;

public class PlantaEnsamblado {
	private static Semaphore pinzas = new Semaphore(4);
	private static Semaphore destornilladores = new Semaphore(2);
	private static Semaphore sargentos = new Semaphore(4);
	private final int tiempof1 = 400;
	private final int tiempof2 = 400 / 2;
	private final int tiempof3 = 2 * 400;
	private static int lista = 20;

	public Boolean emsamblar() {
		if (lista == 0) {
			return true;
		}
		System.out.println("lista actual: " + lista);
		lista--;
		return false;
	}

	public void fase1(String mesa) {
		try {
			pinzas.acquire();
			destornilladores.acquire();
			Thread.sleep(tiempof1);
			pinzas.release();
			destornilladores.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mesa + " termino la fase 1");
	}

	public void fase2(String mesa) {
		try {
			sargentos.acquire(2);
			Thread.sleep(tiempof2);
			sargentos.release(2);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mesa + " termino la fase 2");

	}

	public void fase3(String mesa) {
		try {
			pinzas.acquire(2);
			Thread.sleep(tiempof3);
			pinzas.release(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mesa + " termino la fase 3");

	}

	public static void main(String[] args) {
		PlantaEnsamblado planta = new PlantaEnsamblado();
		Mesa[] mesas = new Mesa[3];
		for (int i = 0; i < mesas.length; i++) {
			mesas[i] = new Mesa(i + 1);
			mesas[i].start();
		}
		for (int i = 0; i < mesas.length; i++) {
			try {
				mesas[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ya se ensamblo todo ");

	}
}