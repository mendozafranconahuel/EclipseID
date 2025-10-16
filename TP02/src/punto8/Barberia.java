package punto8;

import java.util.concurrent.Semaphore;

public class Barberia {
    private Semaphore clientes = new Semaphore(0); // clientes esperando
    private Semaphore barbero = new Semaphore(0);  // barbero listo para cortar
    private Semaphore mutex = new Semaphore(1);    // exclusión mutua
    private int sillasLibres;

    public Barberia(int numSillas) {
        this.sillasLibres = numSillas;
    }

    public class Barbero extends Thread {
        private int id;

        public Barbero(int id) {
            this.id = id;
        }

        public void run() {
            while (true) {
                try {
                    clientes.acquire(); // espera un cliente

                    mutex.acquire();
                    sillasLibres++; // un cliente deja la sala de espera
                    System.out.println("\n * CLIENTE LLAMADO POR BARBERO "+id+".\t> Sillas libres: "+sillasLibres);
                    barbero.release(); // barbero listo
                    mutex.release();

                    cortarPelo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void cortarPelo() {
            try {
                System.out.println("\t\t > BARBERO "+id+" CORTANDO...");
                Thread.sleep(2000); // simula corte
                System.out.println("\t\t < BARBERO "+id+" TERMINO.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Cliente extends Thread {
        private int id;

        public Cliente(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                mutex.acquire();
                if (sillasLibres > 0) {
                    sillasLibres--;
                    	System.out.println("\n - CLIENTE "+id+ " SE SIENTA.\t > Sillas libres: "+sillasLibres);
                    clientes.release(); // avisa que hay cliente esperando
                    mutex.release();
                    barbero.acquire(); // espera al barbero
                } else {
                    System.out.println("\n X CLIENTE "+id+" SE FUE POR NO HABER SILLAS.");
                    mutex.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Barbero crearBarbero(int id) {
        return new Barbero(id);
    }

    public Cliente crearCliente(int id) {
        return new Cliente(id);
    }
}
