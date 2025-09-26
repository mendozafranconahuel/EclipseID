package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class Consumidor extends Thread{
	private ArrayList<Integer> lista;
	private int id_consumidor;
	
	public Consumidor(ArrayList<Integer> lista, int id_consumidor) {
		this.lista = lista;
		this.id_consumidor = id_consumidor;
	}
	
	public void run() {
		synchronized(lista) { //Region Critica
			if(lista.size() == 0) {
				System.out.println(" - NO HAY ELEMENTOS: CONSUMIDOR "+id_consumidor+" DORMIDO.");
				try {
					lista.wait();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(" - CONSUMIDOR "+id_consumidor+": DESPIERTO.\n");
			}
			int quitar = lista.remove(0); //Eliminar el primer elemento FIFO
			System.out.println(" < CONSUMIDOR "+id_consumidor+": "+quitar);
		}

	}
}