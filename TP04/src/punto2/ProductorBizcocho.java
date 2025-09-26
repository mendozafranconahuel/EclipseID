package punto2;

import java.util.Random;

public class ProductorBizcocho extends Thread{
	
	static final int tiempo_minimo = 400;
	static final int tiempo_maximo = 600;
	private Mostrador mostrador;
	private Random random = new Random();
	
	public ProductorBizcocho (Mostrador mostrador) {
		this.mostrador = mostrador;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(tiempo_minimo + random.nextInt(tiempo_maximo - tiempo_minimo + 1));
				mostrador.agregarBizcocho();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
