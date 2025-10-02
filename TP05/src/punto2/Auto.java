package punto2;

import java.util.concurrent.ThreadLocalRandom;

public class Auto implements Runnable {
    private int id;
    private Estacionamiento estacionamiento;

    public Auto(int id, Estacionamiento estacionamiento) {
        this.id = id;
        this.estacionamiento = estacionamiento;
    }

    @Override
    public void run() {
        try {
        	
            // entrar
            estacionamiento.entrar(id);

            // permanecer un tiempo dentro
            int tiempo = ThreadLocalRandom.current().nextInt(1000, 3000);
            Thread.sleep(tiempo);

            // salir
            estacionamiento.salir(id);

        } catch (InterruptedException e) {
        	
            e.printStackTrace();
        }
    }
}