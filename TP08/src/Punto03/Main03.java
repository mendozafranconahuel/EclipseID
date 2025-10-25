package Punto03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main03 {

	public static void main(String[] args) {
		final int CANT_CLIENTES = 50;

        // Permite que solo 3 clientes sean atendidos a la vez
        Semaphore cajas = new Semaphore(3);

        ExecutorService executor = Executors.newFixedThreadPool(CANT_CLIENTES);
        Random random = new Random();

        for (int i = 1; i <= CANT_CLIENTES; i++) {
            int cliente = i;
            executor.execute(() -> {
                try {
                    // Espera una caja libre
                    cajas.acquire();

                    // Tiempo aleatorio entre 1 y 3 segundos
                    int tiempo = 1 + random.nextInt(3);

                    System.out.println("Cliente " + cliente + " comienza atención. Tiempo estimado: " + tiempo + "s");

                    // Simula atención
                    Thread.sleep(tiempo * 1000);

                    System.out.println("Cliente " + cliente + " finalizó atención después de " + tiempo + "s");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {

                	cajas.release();
                }
            });
        }

        executor.shutdown();
	}

}
