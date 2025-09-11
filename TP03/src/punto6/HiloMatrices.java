package punto6;

public class HiloMatrices extends Thread {
	
	// Variables
	protected int[][] MatrizA, MatrizB;
	protected int indice;
	
	// Contructor
	public HiloMatrices(int indice, int[][] MatrizA, int[][] MatrizB) {
		this.indice = indice;
		this.MatrizA = MatrizA;
		this.MatrizB = MatrizB;
	}
	
	// Método que ejecuta el intercambio
	public void run() {
		intercambiar(this.indice, this.MatrizA, this.MatrizB);
	}
	
	// Método que realiza el intercambio de filas por columnas
	public static void intercambiar(int indice, int[][] A, int[][] B) {
		// Variables locales
		int filaA[] = new int[A[indice].length];
		int columnaB[] = new int[B.length];
		int j;
		
		// Copia fila de matriz A
		for (j = 0; j < A[indice].length; j++) {
			filaA[j] = A[indice][j];
		}
		
		// Copia columna de matriz B
		for (j = 0; j < B.length; j++) {
			columnaB[j] = B[j][indice];
		}
		
		// Reemplaza fila de A con columna de B según el parámetro indice
		for (j = 0; j < A[indice].length; j++) {
			A[indice][j] = columnaB[j];
		}
		
		// Reemplaza columna de B con fila de A según el parámetro indice
		for (j = 0; j < B.length; j++) {
			B[j][indice] = filaA[j];
		}
	}
}
