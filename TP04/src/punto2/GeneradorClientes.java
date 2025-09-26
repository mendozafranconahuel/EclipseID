package punto2;

import java.util.Random;

public class GeneradorClientes extends Thread{
	
	static final int tiempo_llegada_minimo = 800;
	static final int tiempo_llegada_maximo = 1500;
	private Mostrador mostrador;
	private Random random = new Random();
	
	public GeneradorClientes(Mostrador mostrador) {
		this.mostrador = mostrador;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(tiempo_llegada_minimo + random.nextInt(tiempo_llegada_maximo - tiempo_llegada_minimo + 1));
				ConsumidorCliente cliente = new ConsumidorCliente(mostrador);
				cliente.start();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
