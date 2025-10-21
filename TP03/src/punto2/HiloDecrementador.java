package punto2;
import metodos.Colorear;

public class HiloDecrementador extends Thread {
	private Contador contador;
	
	public HiloDecrementador(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			contador.decrementar();
			Colorear.rojo(" > Hilo Decrementador - Contador: "+contador.getContador());
		}
	}
}