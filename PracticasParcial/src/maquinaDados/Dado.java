package maquinaDados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Dado extends Thread {
	private int nroDado;
	private static Metodos m = new Metodos();
	private static Semaphore suma = new Semaphore(1);
	private static int sumaDados = 0;
	private static Queue<Integer> lista = new LinkedList<Integer>();

	public Dado(int nroDado) {
		this.nroDado = nroDado;
	}

	@Override
	public void run() {
		try {
			int numero = m.generarNumero();
			suma.acquire();
			sumaDados += numero;
			Dado.lista.offer(numero);
			suma.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Dado[] dados = new Dado[6];
		while (true) {
			for (int i = 0; i < dados.length; i++) {
				dados[i] = new Dado(i + 1);
				dados[i].start();
			}
			for (int i = 0; i < dados.length; i++) {
				dados[i].join();
			}
			System.out.println("Valor dados " + lista + " " + sumaDados);
			m.parImpar(sumaDados);
			m.escalera(lista);
			sumaDados = 0;
			lista.clear();

			Thread.sleep(2000);
		}
	}
}
