package punto1;
import java.util.ArrayList;

public class Punto1B {
    private static final int CAPACIDAD_MAXIMA = 5;
    
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        
        // Número infinito de productores (en práctica, usaremos 10)
        for(int i = 0; i < 10; i++) {
            ProductorB productor = new ProductorB(lista, i, CAPACIDAD_MAXIMA);
            productor.start();
        }
        
        // Número infinito de consumidores (en práctica, usaremos 10)
        for(int i = 0; i < 10; i++) {
            ConsumidorB consumidor = new ConsumidorB(lista, i, CAPACIDAD_MAXIMA);
            consumidor.start();
        }
    }
}