package punto2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Punto2 {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		System.out.println("Inicio");
		ScheduledExecutorService servicio = Executors.newScheduledThreadPool(2);
		servicio.scheduleAtFixedRate(() -> {
			m.tarea1();
		}, 2, 2, TimeUnit.SECONDS);
		servicio.scheduleAtFixedRate(() -> {
			m.tarea2();
		}, 2, 2, TimeUnit.SECONDS);
	}
}

class Metodos {
	private List<String> lista = new CopyOnWriteArrayList<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:S");

	public void tarea1() {
		String elemento = dateFormat.format(new Date());
		lista.add(elemento);
	}

	public void tarea2() {
		if (!lista.isEmpty()) {
			long numero = obtenerMiliseg(lista.getLast());
			if (esPrimo(numero)) {
				System.out.println("encontramos un nro Primo! -> " + numero);
				escribir("Primos.txt", numero);
			} else {
				escribir("NoPrimos.txt", numero);
			}
		} else {
			System.out.println("la lista está vacio, fuimos muy rapidos ");
		}
	}

	public long obtenerMiliseg(String lista) {
		String[] partes = lista.split(":");
		long horas = Long.parseLong(partes[0]) * 60 * 60 * 1000;
		long minutos = Long.parseLong(partes[1]) * 60 * 1000;
		long segundos = Long.parseLong(partes[2]) * 1000;
		return horas + minutos + segundos + Long.parseLong(partes[3]);
	}

	public boolean esPrimo(long numero) {
		if (numero <= 1)
			return false;
		if (numero <= 3)
			return true;
		if (numero % 2 == 0 || numero % 3 == 0)
			return false;
		for (int i = 5; i * i <= numero; i += 6) {
			if (numero % i == 0 || numero % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	public void escribir(String archivo, long numero) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
			writer.println(numero + " -> " + new Date());
		} catch (IOException e) {
			System.err.println("Error al tratar de escribir: " + e.getMessage());
		}

	}
}
