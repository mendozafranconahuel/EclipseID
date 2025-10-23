package listaNumeros;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ListaNumeros extends Thread {
	private static Queue<Integer> lista = new LinkedList<Integer>();
	private Random random = new Random();
	private static int sumalista = 0;

	public void sumar(int numero) {
		sumalista += numero;
		System.out.println("suma actual: " + sumalista);
		if (esCapicua(sumalista)) {
			System.out.println(" la suma ES CAPICUA !!!!!");
		}
	}

	public void promedioLista() {
		double promedio = sumalista / lista.size();
		System.out.println("Promedio actual: " + promedio);
	}

	public static boolean esCapicua(int numero) {
		String numeroStr = String.valueOf(numero);
		String reverso = new StringBuilder(numeroStr).reverse().toString();
		return numeroStr.equals(reverso);
	}

	@Override
	public void run() {
		while (true) {
			int numero = random.nextInt(41) + 90;
			try {
				lista.add(numero);
				System.out.println("se agrego un elemento: " + lista);
				sumar(numero);
				promedioLista();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ListaNumeros hilo = new ListaNumeros();
		hilo.start();
	}
}
