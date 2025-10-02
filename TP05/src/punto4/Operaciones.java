package punto4;

import java.util.Random;

public class Operaciones {

	public static double SumRoot(int root) {
		double result = 0;
		for (int i = 0; i < 10000000; i++) {
			result += Math.exp(Math.log(i) / root);
		}
		return result;
	}

	public static int[][] generarMatriz(int fila, int columna) {
		Random random = new Random();
		int[][] matrizGenerada = new int[fila][columna];
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				matrizGenerada[i][j] = random.nextInt(100);
			}
		}
		return matrizGenerada;
	}

	public static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(((matriz[i][j] < 10) ? " " + matriz[i][j] + " " : matriz[i][j] + " "));
			}
			System.out.println();
		}
	}

	public static void mostrarMatrizDouble(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
