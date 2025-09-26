package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class ProductorA extends Thread {
    private ArrayList<Integer> lista;
    private int id_productor;
    
    public ProductorA(ArrayList<Integer> lista, int id_productor) {
        this.lista = lista;
        this.id_productor = id_productor;
    }
    
    public void run() {
        for(int r = 0; r < 10; r++) {
            try {
                // Productor lento: 1000ms - 1500ms
                int tiempoProduccion = Metodo.generarEntero(1000, 1500);
                Thread.sleep(tiempoProduccion);
                
                int elemento = Metodo.generarEntero(1, 100);
                
                synchronized(lista) {
                    lista.add(elemento);
                    System.out.println("Productor " + id_productor + " produjo: " + elemento + 
                                     " (Tamaño cola: " + lista.size() + ")");
                    lista.notifyAll(); // Notificar a todos los consumidores
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Productor " + id_productor + " terminó");
    }
}