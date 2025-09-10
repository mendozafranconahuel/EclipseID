package punto2;

public class hiloContador extends Thread {
    private Contador contador;
    private int idHilo;

    public hiloContador(int idHilo, Contador contador) {
        this.idHilo = idHilo;
        this.contador = contador;
    }

    @Override
    public void run() {
    	synchronized(contador) {
            for (int i = 0; i < 100; i++) {
                contador.incrementar();
                System.out.println("Hilo " + idHilo + " - Contador: " + contador.getContador());
            }
    	}
    }
    
}