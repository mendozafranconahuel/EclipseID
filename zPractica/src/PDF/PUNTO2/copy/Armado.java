package PDF.PUNTO2.copy;

import java.util.concurrent.Semaphore;
import metodos.Colorear;

public class Armado extends Thread {
	private int id;
	private int tiempo = 400;
	private static Semaphore pinzas = new Semaphore(2);
	private static Semaphore destornilladores = new Semaphore(2);
	private static Semaphore sargentos = new Semaphore(4);
	
	public Armado (int id) {
		this.id = id;
	}
	
	public int definirTiempo(int fase) {
		switch(fase) {
			case 1:
				return tiempo;
			case 2:
				return tiempo / 2;
			case 3:
				return tiempo * 2;
			default:
				return 0;
		}
	}
	
	public synchronized void run() {
		try {
			int fase = 1;
			// Fase 1
			pinzas.acquire(1);
			destornilladores.acquire(1);
				Colorear.rojo(" - Componente " + id + " en Fase 1("+definirTiempo(fase)+"ms)");
					Thread.sleep(definirTiempo(fase));
			pinzas.release(1);
			destornilladores.release(1);
			
			// Fase 2
			fase++;
			sargentos.acquire(2);
				Colorear.azul(" - Componente " + id + " en Fase 2("+definirTiempo(fase)+"ms)");
					Thread.sleep(definirTiempo(fase));
			sargentos.release(2);
			
			// Fase 3
			fase++;
			pinzas.acquire(2);
				Colorear.verde(" - Componente " + id + " en Fase 3("+definirTiempo(fase)+"ms)");
					Thread.sleep(definirTiempo(fase));
			pinzas.release(2);
			
			System.out.println(" - Componente " + id + " armado completamente.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//run
}//class
