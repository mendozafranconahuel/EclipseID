package punto1;
import metodos.Colorear;

public class Impresion extends Thread {
	
	String letra;
	String color;
	
	//constructor
	public Impresion(String letra, String color) {
		this.letra = letra;
		this.color = color;
	}
	
	//CONCEPTO JOIN: El método join() en Java se utiliza para hacer que un hilo espere a que otro hilo termine su ejecución antes de continuar con su propio flujo de ejecución.
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			String texto = i+letra+" ";
			Colorear.seleccionar(color,texto);
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e ) {
				System.out.println("Hilo interrumpido");
				e.printStackTrace();
			}
		}
		
	}
}
