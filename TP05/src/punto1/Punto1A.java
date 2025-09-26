package punto1;
import java.util.ArrayList;

public class Punto1A {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        
        // 10 productores
        for(int i = 0; i < 10; i++) {
            ProductorA productor = new ProductorA(lista, i);
            productor.start();
        }
        
        // 10 consumidores
        for(int i = 0; i < 10; i++) {
            ConsumidorA consumidor = new ConsumidorA(lista, i);
            consumidor.start();
        }
    }
}