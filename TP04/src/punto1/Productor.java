package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class Productor extends Thread{
	private ArrayList<Integer> lista;
	private int id_producto;
	
	public Productor(ArrayList<Integer> lista, int id_producto) {
		this.lista = lista;
		this.id_producto = id_producto;
	}
	
	public void run() {
		int inicio = 10, fin = 100;	
			for(int r = 0; r < 10; r++) {
				int espera = Metodo.generarEntero(100, 200);
					try {
						//Thread.sleep(espera);
						synchronized(lista) {
							Thread.sleep(espera);
							lista.add(espera);
							lista.notify();
							System.out.println("\n > ELEMENTO "+id_producto+": "+espera);
						}
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				
			}
	}
}