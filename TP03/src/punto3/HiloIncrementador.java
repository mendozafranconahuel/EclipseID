package punto3;
import punto2.Contador;
import punto2.Colorear;
import java.util.Random;


public class HiloIncrementador extends Thread {
    private Contador contador;
	private Random random;

    public HiloIncrementador(Contador contador) {
        this.contador = contador;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contador.incrementar();
            String mensaje = " > Hilo Incrementador - Contador: "+contador.getContador();
            System.out.println(Colorear.azul(mensaje));
            try {
				// Retardo aleatorio entre 50-150ms
                Thread.sleep(random.nextInt(101) + 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}