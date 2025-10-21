package punto2;
public class Principal {
	public static void main(String[] args) {
		
		Contador hiloIncrementador = new Contador("incrementar");
		Contador hiloDecrementador = new Contador("decrementar");
		
		hiloIncrementador.start();
		hiloDecrementador.start();
		
		try {
			hiloIncrementador.join();
			hiloDecrementador.join();
		}
		catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
	}
}