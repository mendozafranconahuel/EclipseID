package PARCIAL2023.PUNTO2;

import java.util.concurrent.Semaphore;

import metodos.Metodo;
import metodos.Colorear;

public class Aspirante extends Thread {
    private int id;
    private Semaphore pista1;
    private Semaphore pista2;
    private Pasillo pasillo;
    private int tiempo1;
    private int tiempo2;

    public Aspirante(int id, Semaphore pista1, Semaphore pista2, Pasillo pasillo) {
        this.id = id;
        this.pista1 = pista1;
        this.pista2 = pista2;
        this.pasillo = pasillo;
        this.tiempo1 = Metodo.generarEntero(1100, 1300); // 1100–1300ms
        this.tiempo2 = Metodo.generarEntero(600, 800);;  // 600–800ms
    }

    @Override
    public void run() {
        try {
            // Espera turno para pista 1
            pista1.acquire();
            Colorear.verde("   * Aspirante"+id+": INGRESA A PISTA 1.");
            	Thread.sleep(tiempo1);
            Colorear.rojo("\t Aspirante"+id+": SALE DE PISTA 1.");
            pista1.release();

            // Entra al pasillo
            pasillo.esperar(id);

            // Espera turno para pista 2
            pista2.acquire();
            Colorear.azul("        ** Aspirante "+id+" INGRESA A PISTA 2.");
            	Thread.sleep(tiempo2);
            Colorear.rojo("\t Aspirante "+id+" SALE DE PISTA 2. FINALIZA Y EGRESA DEL RECINTO.");
            pista2.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
