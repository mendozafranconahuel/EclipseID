package punto2;
import metodos.Colorear;

public class HiloIncrementador extends Thread {
	private Contador contador;

	public HiloIncrementador(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			contador.incrementar();
			Colorear.azul(" > Hilo Incrementador - Contador: "+contador.getContador());
		}
	}
}
