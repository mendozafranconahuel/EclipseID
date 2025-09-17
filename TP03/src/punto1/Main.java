package punto1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Hilo hiloX = new Hilo("X");
		Hilo hiloY = new Hilo("Y");

		// Punto 1: inciso A y B
		hiloX.start();
		hiloY.start();
		// Punto 1: inciso C
//		hiloX.start();
//		hiloX.join(); 
//		hiloY.start();
//		hiloY.join(); 

		// Punto 1: inciso D
//		hiloX.start();
//		hiloX.join(); //espera a que termine hiloX para iniciar hiloY
//		hiloY.start();
		// Punto 1: inciso E
		// al usar hilos sin sincronizacion, los resultados pueden variar en cada
		// ejecucion
		// ya que los hilos pueden ejecutarse en cualquier orden y de manera intercalada
	}

}

class Hilo extends Thread {
	private String letra;

	public Hilo(String letra) {
		this.letra = letra;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print(i + letra);
		}
	}

}

class Cadena {
	private ArrayList<String> lista = new ArrayList<>();

	public Cadena() {
	}

	public void setValor(String valor) {
		lista.add(valor);
	}
//	public void obtenerCadenaMasLarga() {
//		String cadenaMasLarga = "";
//		for (String s : lista) {
//			if (s.charAt(1) == ) {
//				cadenaMasLarga = s;
//			}
//		}
//		System.out.println("Cadena mas larga: " + cadenaMasLarga);
//	}
}
