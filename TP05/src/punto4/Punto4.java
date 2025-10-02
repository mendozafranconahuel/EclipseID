package punto4;

public class Punto4 {

	public static void main(String[] args) throws InterruptedException {
		long tiempoInicial = System.currentTimeMillis();
		int[][] matrizA = Operaciones.generarMatriz(20, 15);
		int[][] matrizB = Operaciones.generarMatriz(15, 20);
		double[][] matrizC = new double[matrizA.length][matrizB[0].length];

		System.out.println("matriz A");
		Operaciones.mostrarMatriz(matrizA);
		System.out.println("matriz B");
		Operaciones.mostrarMatriz(matrizB);

		Thread[] hilos = new Thread[matrizA.length * matrizB[0].length];
		int contador = 0;
		for (int fila = 0; fila < matrizA.length; fila++) {
			for (int columna = 0; columna < matrizB[0].length; columna++) {
				Runnable calculoConcurrente = new CalculoConcurrente(matrizA, matrizB, matrizC, fila, columna);
				hilos[contador] = new Thread(calculoConcurrente);
				hilos[contador].start();
				contador++;
			}
		}

		for (Thread h : hilos) {
			h.join();
		}
		System.out.println("matriz C");
		Operaciones.mostrarMatrizDouble(matrizC);

		long tiempoFinal = System.currentTimeMillis();
		long tiempoEjecucion = tiempoFinal - tiempoInicial;
		System.out.println("tiempo de ejecucion: " + tiempoEjecucion);
	}// main_
}// final_Punto4
