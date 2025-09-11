package punto6;
import java.util.Random;

public class Punto6 {
	
	// Variables estáticas para creación de matrices
	static final int filas_A = 100;
	static final int columnas_A = 200;
	static final int filas_B = 200;
	static final int columnas_B = 100;
	static final int limite_valores_aleatorios = 100;
	
	public static void main(String[] args) {
		
		// Creación de variables
		Random generador = new Random();
		int MatrizA[][] = new int[filas_A][columnas_A];
		int MatrizB[][] = new int[filas_B][columnas_B];
		HiloMatrices hilos[] = new HiloMatrices[filas_A];
		int i, j;
		
		// Iniciación de valores de matrices A y B
		for (i = 0; i < filas_A; i++) {
			for (j = 0; j < columnas_A; j++) {
				MatrizA[i][j] = generador.nextInt(limite_valores_aleatorios) + 1;
				MatrizB[j][i] = generador.nextInt(limite_valores_aleatorios) + 1;
			}
		}
		
		// Muestreo de Matrices por pantalla antes del intercambio
		System.out.println("\nMatriz A (antes): ");
		imprimirMatriz(MatrizA);
		System.out.println("\nMatriz B (antes): ");
		imprimirMatriz(MatrizB);
		
		// Iniciación de hilos que ejecutan el intercambio
		for (i = 0; i < filas_A; i++) {
			final int indice = i;
			hilos[i] = new HiloMatrices(indice, MatrizA, MatrizB);
			hilos[i].start();
		}
		
		// Espera la terminación de los hilos
		for (HiloMatrices t : hilos) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("ERROR DURANTE LA EJECUCIÓN");
			}
		}
		
		// Muestreo de Matrices por pantalla después del intercambio
		System.out.println("\nMatriz A (después):");
		imprimirMatriz(MatrizA);
		System.out.println("\nMatriz B (después):");
		imprimirMatriz(MatrizB);
		
	}
	
	// Método que ayuda a imprimir por pantalla la matriz
	public static void imprimirMatriz(int[][] matriz) {
 		for (int[] fila : matriz) {
			for (int valor : fila) {
				System.out.printf("%2d ", valor);
			}
			System.out.println();
 		}
	}
}
