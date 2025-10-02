package punto1;

import java.util.LinkedList;
import java.util.List;

public class Buffer {
    private final List<String> queue = new LinkedList<>();

    // Inserta un item (cola infinita)
    public synchronized void put(String item) {
        queue.add(item);
        notifyAll(); // notificar consumidores
    }

    // Extrae el primer item (bloquea si está vacío)
    public synchronized String take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.remove(0);
    }

    // Tamaño actual (para logging)
    public synchronized int size() {
        return queue.size();
    }
}
