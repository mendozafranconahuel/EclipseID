package punto2;

import java.util.Random;

public class ProductorFactura extends Thread {
	
	static final int tiempo_minimo = 1000;
	static final int tiempo_maximo = 1300;
	private Mostrador mostrador;
	private Random random = new Random();
	
	public ProductorFactura(Mostrador mostrador) {
		this.mostrador = mostrador;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(tiempo_minimo + random.nextInt(tiempo_maximo - tiempo_minimo + 1));
				mostrador.agregarFactura();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
