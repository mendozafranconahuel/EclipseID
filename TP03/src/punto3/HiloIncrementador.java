package punto3;
import metodos.Colorear;
import metodos.Metodo;

public class HiloIncrementador extends Thread {
	private Contador contador;

	public HiloIncrementador(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			contador.incrementar();
			int retardo = Metodo.generarEntero(50, 150);
			Colorear.azul(" > Hilo Incrementador - Contador: "+contador.getContador());
			
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
