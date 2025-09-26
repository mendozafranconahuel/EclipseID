package punto2;

import java.util.Random;

public class ConsumidorCliente extends Thread {
	
	static final int tiempo_retirada_minimo = 200;
	static final int tiempo_retirada_maximo = 400;
	private static int contador = 1;
	private String nombre;
	private Mostrador mostrador;
	private Random random = new Random();
	
	public ConsumidorCliente(Mostrador mostrador) {
		this.mostrador = mostrador;
		this.nombre = "[CLIENTE " + (contador++) + "]";
	}
	
	public void run() {
		try {
			mostrador.comprar(nombre);
			Thread.sleep(tiempo_retirada_minimo + random.nextInt(tiempo_retirada_maximo - tiempo_retirada_minimo + 1));
			System.out.println(nombre + " se retira del local.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
