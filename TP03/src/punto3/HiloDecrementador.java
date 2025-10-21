package punto3;
import metodos.Colorear;
import metodos.Metodo;

public class HiloDecrementador extends Thread {
	private Contador contador;
	
	public HiloDecrementador(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			contador.decrementar();
			int retardo = Metodo.generarEntero(50, 150);
			
			Colorear.rojo(" > Hilo Decrementador - Contador: "+contador.getContador());
			
			try {
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}