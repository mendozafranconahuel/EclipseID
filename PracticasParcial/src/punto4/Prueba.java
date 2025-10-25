package punto4;

public class Prueba {
	public static void main(String[] args) throws InterruptedException {
		Caja caja = new Caja();
		Thread misHilos[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			misHilos[i] = new Thread(() -> caja.incrementar());
			misHilos[i].start();
		}
		for (int i = 0; i < 5; i++) {
			misHilos[i].join();
		}
		caja.mostrar();

	}
}

class Caja {
	public int valor = 0;

	public synchronized void incrementar() {
		valor++;
		if (valor == 5) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
	}

	public synchronized void mostrar() {
		System.out.println("Valor: " + valor);
		notify();
	}

}
