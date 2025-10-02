package punto4;

public class CalculoConcurrente extends Operaciones implements Runnable {
	private int[][] matrizA;
	private int[][] matrizB;
	double[][] matrizC;
	private int fila;
	private int columna;

	public CalculoConcurrente(int[][] matrizA, int[][] matrizB, double[][] matrizC, int fila, int columna) {
		this.matrizA = matrizA;
		this.matrizB = matrizB;
		this.matrizC = matrizC;
		this.fila = fila;
		this.columna = columna;
	}

	@Override
	public void run() {
		int resultado = 0;
		for (int i = 0; i < 15; i++) {
			resultado += matrizA[fila][i] * matrizB[i][columna];
		}
		double elemento = SumRoot(resultado);
		synchronized (matrizC) {
			matrizC[fila][columna] = resultado;
		}
	}
}
