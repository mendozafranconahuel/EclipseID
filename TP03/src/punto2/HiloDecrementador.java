package punto2;

public class HiloDecrementador extends Thread {
    private Contador contador;

    public HiloDecrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contador.decrementar();
            String mensaje = " > Hilo Decrementador - Contador: "+contador.getContador();
            System.out.println(Colorear.rojo(mensaje));
        }
    }
}