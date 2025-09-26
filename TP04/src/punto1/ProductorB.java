package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class ProductorB extends Thread {
    private ArrayList<Integer> lista;
    private int id_productor;
    private int capacidadMaxima;
    
    public ProductorB(ArrayList<Integer> lista, int id_productor, int capacidadMaxima) {
        this.lista = lista;
        this.id_productor = id_productor;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public void run() {
        for(int r = 0; r < 10; r++) {
            try {
                // Productor rápido: 400ms - 800ms
                int tiempoProduccion = Metodo.generarEntero(400, 800);
                Thread.sleep(tiempoProduccion);
                
                int elemento = Metodo.generarEntero(1, 100);
                
                synchronized(lista) {
                    while(lista.size() >= capacidadMaxima) {
                        System.out.println("Productor " + id_productor + " esperando (cola llena)...");
                        lista.wait();
                    }
                    
                    lista.add(elemento);
                    System.out.println("Productor " + id_productor + " produjo: " + elemento + 
                                     " (Tamaño cola: " + lista.size() + "/" + capacidadMaxima + ")");
                    lista.notifyAll(); // Notificar a consumidores
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Productor " + id_productor + " terminó");
    }
}