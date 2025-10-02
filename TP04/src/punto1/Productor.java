package punto1;
import java.util.Random;


public class Productor extends Thread {
    private final Buffer buffer;
    private final int id;
    private final Random rnd = new Random();

    public Productor(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
        setName("Productor-" + id);
    }

    @Override
    public void run() {
        int produced = 0;
        while (true) {
            try {
                // Tiempo de producción: 1000 - 1500 ms
                int t = 1000 + rnd.nextInt(501);
                Thread.sleep(t);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido. Termina.");
                break;
            }

            String item = getName() + "-item-" + (++produced) + "@" + System.currentTimeMillis();
            buffer.put(item);
            System.out.printf("%s produjo <%s> (cola=%d)%n", getName(), item, buffer.size());
        }
    }
}
