package punto1;

import java.util.Random;

public class Consumidor extends Thread {
    private final Buffer buffer;
    private final int id;
    private final Random rnd = new Random();

    public Consumidor(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
        setName("Consumdidor-" + id);
    }

    @Override
    public void run() {
        while (true) {
            String item;
            try {
                // Intentar tomar (bloquea internamente si vacía)
                item = buffer.take();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido mientras esperaba. Termina.");
                break;
            }

            try {
                // Tiempo de consumo: 400 - 800 ms
                int t = 400 + rnd.nextInt(401);
                Thread.sleep(t);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido durante consumo. Termina.");
                break;
            }

            System.out.printf("%s consumió <%s> (cola=%d)%n", getName(), item, buffer.size());
        }
    }
}