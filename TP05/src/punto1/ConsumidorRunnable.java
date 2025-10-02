package punto1;

import java.util.Random;

public class ConsumidorRunnable implements Runnable {
    private final Buffer buffer;
    private final int id;
    private final Random rnd = new Random();

    public ConsumidorRunnable(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String hiloNombre = "Consumer-" + id;
        while (true) {
            String item;
            try {
                // Tomar (bloquea si está vacío)
                item = buffer.take();
            } catch (InterruptedException e) {
                System.out.println(hiloNombre + " interrumpido mientras esperaba. Termina.");
                break;
            }

            try {
                // Tiempo de consumo: 400 - 800 ms
                int t = 400 + rnd.nextInt(401);
                Thread.sleep(t);
            } catch (InterruptedException e) {
                System.out.println(hiloNombre + " interrumpido durante consumo. Termina.");
                break;
            }

            System.out.printf("%s consumió <%s> (cola=%d)%n", hiloNombre, item, buffer.size());
        }
    }
}