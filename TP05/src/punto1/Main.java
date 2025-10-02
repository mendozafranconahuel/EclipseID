package punto1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        //PUNTO 2 DEL TRABAJO PRÁCTICO NRO 3 CON RUNNABLE
        
        // Creamos los objetos Runnable
        HiloContador tarea1 = new HiloContador(1, contador);
        HiloContador tarea2 = new HiloContador(2, contador);

        // Los pasamos al constructor de Thread
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        hilo1.start();
        hilo2.start();
        
        //PUNTO 1a) DEL TRABAJO PRÁCTICO NRO 4 CON RUNNABLE
        
        final int N_PRODUCTORES = 10;
        final int N_CONSUMIDORES = 10;

        Buffer buffer = new Buffer();
        Random rnd = new Random();

        List<Thread> started = new ArrayList<>();

        int productoresIniciados = 0;
        int consumidoresIniciados = 0;

        // Lanzamiento aleatorio con intervalos 100 - 200 ms
        while (productoresIniciados < N_PRODUCTORES || consumidoresIniciados < N_CONSUMIDORES) {
            boolean lanzarProductor;
            if (productoresIniciados >= N_PRODUCTORES) {
                lanzarProductor = false;
            } else if (consumidoresIniciados >= N_CONSUMIDORES) {
                lanzarProductor = true;
            } else {
                lanzarProductor = rnd.nextBoolean();
            }

            if (lanzarProductor) {
                productoresIniciados++;
                ProductorRunnable prod = new ProductorRunnable(productoresIniciados, buffer);
                Thread t = new Thread(prod, "Productor-" + productoresIniciados);
                t.setDaemon(true); // opcional: que no impida terminar la JVM si main termina
                t.start();
                started.add(t);
                System.out.println("Lanzado " + t.getName());
            } else {
                consumidoresIniciados++;
                ConsumidorRunnable cons = new ConsumidorRunnable(consumidoresIniciados, buffer);
                Thread t = new Thread(cons, "Consumidor-" + consumidoresIniciados);
                t.setDaemon(true);
                t.start();
                started.add(t);
                System.out.println("Lanzado " + t.getName());
            }

            try {
                int wait = 100 + rnd.nextInt(101); // 100..200 ms
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                System.out.println("Lanzador interrumpido.");
                break;
            }
        }

        System.out.println("Se lanzaron todos los productores y consumidores. (Ctrl+C para terminar)");
        // Mantener main vivo indefinidamente para ver logs (si los threads son daemon, la JVM puede terminar si main sale)
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("Main interrumpido. Saliendo.");
        }
    }
}