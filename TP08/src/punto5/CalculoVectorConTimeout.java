package punto5;

import java.math.BigInteger;
import java.util.concurrent.*;

public class CalculoVectorConTimeout {
	static BigInteger M = new BigInteger("1999");
	private static long[] vector = new long[] { 100477L, 105477L, 112986L, 100078L, 165987L, 142578L };

	private static BigInteger compute(long n) {
		String s = "";
		for (long i = 0; i < n; i++) {
			s = s + n;
		}
		return new BigInteger(s.toString()).mod(M);

	}

	public static void main(String[] args) {
		System.out.println("=== CÁLCULO CON TIMEOUT Y MANEJO DE ERRORES ===");

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<BigInteger>[] futures = new Future[vector.length];

		// Enviar tareas con timeout individual
		for (int i = 0; i < vector.length; i++) {
			final int idx = i;
			futures[i] = executor.submit(() -> compute(vector[idx]));
		}

		executor.shutdown();

		System.out.println("\n=== RESULTADOS CON TIMEOUT ===");
		for (int i = 0; i < vector.length; i++) {
			try {
				// Timeout de 35 segundos por tarea
				BigInteger resultado = futures[i].get(35, TimeUnit.SECONDS);
				System.out.printf("vector[%d] = %d → %s%n", i, vector[i], resultado);
			} catch (TimeoutException e) {
				System.out.printf("vector[%d] = %d → TIMEOUT (más de 35 segundos)%n", i, vector[i]);
				futures[i].cancel(true);
			} catch (Exception e) {
				System.out.printf("vector[%d] = %d → ERROR: %s%n", i, vector[i], e.getMessage());
			}
		}
	}
}