package PARCIAL2023.PUNTO1;

import java.util.concurrent.Semaphore;

public class Proceso extends Thread {
    private String letra;
    private int repeticiones;
    private Semaphore miSemaforo;
    private Semaphore siguienteSemaforo;

    public Proceso(String letra, int repeticiones, Semaphore miSemaforo, Semaphore siguienteSemaforo) {
        this.letra = letra;
        this.repeticiones = repeticiones;
        this.miSemaforo = miSemaforo;
        this.siguienteSemaforo = siguienteSemaforo;
    }
    
    public String getLetra() {
		return letra;
	}

    @Override
    public void run() {
        try {
            for (int i = 0; i < repeticiones; i++) {
                miSemaforo.acquire();           	// Espera su turno
                System.out.print(getLetra());       // Imprime su letra
                siguienteSemaforo.release();    	// Despierta al siguiente
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
