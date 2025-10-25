package punto1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploPool {

    // Método estático que realiza el cálculo matemático
    public static void SumRootN(int root) {
        double result = 0;
        for (int i = 1; i < 10_000_000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        System.out.println("Tarea " + root + " | Resultado: " + result);
    }

    // Clase interna que representa una tarea ejecutable
    static class Tarea implements Runnable {
        private final int numeroTarea;

        public Tarea(int numeroTarea) {
            this.numeroTarea = numeroTarea;
        }

        @Override
        public void run() {
            System.out.println("Iniciando tarea " + numeroTarea + " en hilo: " + Thread.currentThread().getName());
            SumRootN(numeroTarea);
            System.out.println("Finalizando tarea " + numeroTarea);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inicio del programa en: " + Thread.currentThread().getName());

        long inicio = System.currentTimeMillis();// Medición del tiempo total
        ExecutorService executor = Executors.newFixedThreadPool(3);// Crear un pool de tamaño 3
        
        for (int i = 1; i <= 10; i++) {// Enviar 10 tareas al pool
            executor.submit(new Tarea(i));
        }
        executor.shutdown();// Cerrar el executor: no acepta más tareas

        try {
            // Esperar que terminen todas las tareas (máximo 1 hora por seguridad)
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de ejecución: " + (fin - inicio) + " ms");
    }
}