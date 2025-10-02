package punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int N_PRODUCTOR = 10;
        final int N_CONSUMIDOR = 10;

        Buffer buffer = new Buffer();
        Random rnd = new Random();

        List<Thread> started = new ArrayList<>();

        int comenzarProductor = 0;
        int comenzarConsumidor = 0;

        // Lanzamiento aleatorio con intervalos 100 - 200 ms
        while (comenzarProductor < N_PRODUCTOR || comenzarConsumidor < N_CONSUMIDOR) {
            boolean launchProducer;
            if (comenzarProductor >= N_PRODUCTOR) {
                launchProducer = false;
            } else if (comenzarConsumidor >= N_CONSUMIDOR) {
                launchProducer = true;
            } else {
                launchProducer = rnd.nextBoolean();
            }

            if (launchProducer) {
                Productor p = new Productor(++comenzarProductor, buffer);
                p.start();
                started.add(p);
                System.out.println("Lanzado " + p.getName());
            } else {
                Consumidor c = new Consumidor(++comenzarConsumidor, buffer);
                c.start();
                started.add(c);
                System.out.println("Lanzado " + c.getName());
            }

            try {
                int wait = 100 + rnd.nextInt(101); // 100..200
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                System.out.println("Launcher interrumpido.");
                break;
            }
        }

        System.out.println("Se lanzaron todos los productores y consumidores. (Ctrl+C para terminar)");
        // Mantener main vivo (dejamos que los threads corran indefinidamente)
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("Main interrumpido. Saliendo.");
        }
    }
}