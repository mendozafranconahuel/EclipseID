package punto2;

public class HiloIncrementador extends Thread {
    private Contador contador;

    public HiloIncrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contador.incrementar();
            String mensaje = " > Hilo Incrementador - Contador: "+contador.getContador();
            System.out.println(Colorear.azul(mensaje));
        }
    }
}