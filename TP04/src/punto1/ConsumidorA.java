package punto1;
import metodos.Metodo;
import java.util.ArrayList;

public class ConsumidorA extends Thread {
    private ArrayList<Integer> lista;
    private int id_consumidor;
    
    public ConsumidorA(ArrayList<Integer> lista, int id_consumidor) {
        this.lista = lista;
        this.id_consumidor = id_consumidor;
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
                                 " (Tamaño cola: " + lista.size() + ")");
            }
            
            try {
                // Consumidor rápido: 400ms - 800ms
                int tiempoConsumo = Metodo.generarEntero(400, 800);
                Thread.sleep(tiempoConsumo);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor " + id_consumidor + " terminó");
    }
}