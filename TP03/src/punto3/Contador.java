package punto3;
public class Contador {
	private int contador;
	
	public Contador() {
		this.contador = 100;
	}
	
	public synchronized void incrementar() {
	contador = contador + 1;
	setContador(contador);
	}
	
	public synchronized void decrementar() {
	contador = contador - 1;
	setContador(contador);
	}
	
	public synchronized int getContador() {
	return contador;
	}
	
	public synchronized void setContador(int contador) {
		this.contador = contador;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			incrementar();
			decrementar();
		}
	}
	
	
}//Contador