package maquinaDados;

import java.util.Queue;
import java.util.Random;

public class Metodos {
	private Random random = new Random();

	public int generarNumero() {
		return random.nextInt(6) + 1;
	}

	public void parImpar(int suma) {
		if (suma % 2 == 0) {
			System.out.println("La lista es Par");
		} else {
			System.out.println("La lista es Impar");
		}
	}

	public void escalera(Queue<Integer> lista) {
		boolean escalera = true;
		while (!lista.isEmpty()) {
			if (lista.contains(lista.poll())) {
				System.out.println("No es escalera");
				escalera = false;
				break;
			}
		}
		if (escalera) {
			System.out.println("SE HA PRODUCIDO UNA ESCALERA!!!!");
		}

	}

}
