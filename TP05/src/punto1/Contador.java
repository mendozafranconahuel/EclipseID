package punto1;

public class Contador {
    private int contador;

    // inicializo el contador en 100
    public Contador() {
        this.contador = 100;
    }

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}