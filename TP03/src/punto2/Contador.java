package punto2;

public class Contador {
    static private int contador;

    public Contador() {
        Contador.contador = 100;
    }

    public synchronized void incrementar() {
        contador = contador + 1;
        setContador(contador);
    }
    
    public synchronized void decrementar() {
        contador = contador - 1;
        setContador(contador);
    }

    public int getContador() {
        return contador;
    }

	public static void setContador(int contador) {
		Contador.contador = contador;
	}
}   