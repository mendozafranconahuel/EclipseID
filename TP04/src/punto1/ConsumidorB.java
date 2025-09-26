package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class ConsumidorB extends Thread {
    private ArrayList<Integer> lista;
    private int id_consumidor;
    private int capacidadMaxima;
    
    public ConsumidorB(ArrayList<Integer> lista, int id_consumidor, int capacidadMaxima) {
        this.lista = lista;
        this.id_consumidor = id_consumidor;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public void run() {
        for(int r = 0; r < 10; r++) {
            synchronized(lista) {
                while(lista.isEmpty()) {
                    try {
                        System.out.println("Consumidor " + id_consumidor + " esperando...");
                        lista.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                int elemento = lista.remove(0);
                System.out.println("Consumidor " + id_consumidor + " consumió: " + elemento + 
                                 " (Tamaño cola: " + lista.size() + "/" + capacidadMaxima + ")");
                lista.notifyAll(); // Notificar a productores que hay espacio
            }
            
            try {
                // Consumidor lento: 1000ms - 1500ms
                int tiempoConsumo = Metodo.generarEntero(1000, 1500);
                Thread.sleep(tiempoConsumo);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor " + id_consumidor + " terminó");
    }
}