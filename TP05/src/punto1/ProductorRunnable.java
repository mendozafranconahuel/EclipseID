package punto1;

import java.util.Random;

public class ProductorRunnable implements Runnable {
    private final Buffer buffer;
    private final int id;
    private final Random rnd = new Random();

    public ProductorRunnable(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String nombreHilo = "Productor-" + id;
        int produced = 0;
        while (true) {
            try {
                // Tiempo de producción: 1000 - 1500 ms
                int t = 1000 + rnd.nextInt(501);
                Thread.sleep(t);
            } catch (InterruptedException e) {
                System.out.println(nombreHilo + " interrumpido. Termina.");
                break;
            }

            String item = nombreHilo + "-item-" + (++produced) + "@" + System.currentTimeMillis();
            buffer.put(item);
            System.out.printf("%s produjo <%s> (cola=%d)%n", nombreHilo, item, buffer.size());
        }
    }
}
