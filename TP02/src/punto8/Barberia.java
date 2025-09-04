package punto8;

import java.util.concurrent.Semaphore;

public class Barberia {

    private Semaphore clientes = new Semaphore(0);   //clientes esperando
    private Semaphore barbero = new Semaphore(0);    //barbero listo para cortar
    private Semaphore mutex = new Semaphore(1);      //exclusión mutua

    private int sillasLibres;   //número de sillas libres en la sala de espera

    public Barberia(int numSillas) {
        this.sillasLibres = numSillas;
    }

    
    class Barbero extends Thread {
        public void run() {
            while (true) {
                try {
                    clientes.acquire(); //espera que llegue un cliente

                    mutex.acquire();
                    sillasLibres++; //un cliente deja la sala de espera
                    System.out.println("\n * CLIENTE ESPERANDO SENTADO.\t> Sillas libres: " + sillasLibres);
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
                System.out.println("\t\t > BARBERO CORTANDO...");
                	Thread.sleep(2000); //simula tiempo de corte
                System.out.println("\t\t < BARBERO TERMINO.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class Cliente extends Thread {
        private int id;

        public Cliente(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                mutex.acquire();
                if (sillasLibres > 0) {
                    sillasLibres--; //se sienta
                    System.out.println("\n - CLIENTE " + id + " SE SIENTA.\t > Sillas libres: " + sillasLibres);
                    clientes.release(); //avisa que hay un cliente
                    mutex.release();

                    barbero.acquire(); //espera al barbero
                } else {
                    System.out.println("\n X CLIENTE " + id + " SE FUE POR NO HABER SILLAS.");
                    mutex.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public Barbero crearBarbero() {
        return new Barbero();
    }

    public Cliente crearCliente(int id) {
        return new Cliente(id);
    }
}
