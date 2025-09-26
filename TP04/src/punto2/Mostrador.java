package punto2;

import java.util.ArrayList;

public class Mostrador {
	
	private final ArrayList<String> bizcochos = new ArrayList<>();
	private final ArrayList<String> facturas = new ArrayList<>();
	private int contadorBizcocho = 1;
	private int contadorFactura = 1;
	
	public void agregarBizcocho() {
		synchronized (bizcochos) {
			String b = "Bizcocho" + (contadorBizcocho++);
			bizcochos.add(b);
			System.out.println("Panadería produjo " + b + " y lo colocó en el mostrador.");
			bizcochos.notify();
		}
	}
	
	public void agregarFactura() {
		synchronized (facturas) {
			String f = "Factura" + (contadorFactura++);
			facturas.add(f);
			System.out.println("[PANADERÍA] produjo " + f + " y lo colocó en el mostrador.");
			facturas.notify();
		}
	}
	
	public void comprar(String cliente) {
		String b, f;
		
		synchronized (bizcochos) {
			while (bizcochos.isEmpty()) {
				System.out.println(cliente + " espera un Bizcocho.");
				try {
					bizcochos.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			b = bizcochos.remove(0);
		}
		
		synchronized (facturas) {
			while (facturas.isEmpty()) {
				System.out.println(cliente + " espera una Factura.");
				try {
					facturas.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			f = facturas.remove(0);
		}
		
		System.out.println(cliente + " compró " + b + " y " + f + ".");
	}
	
}
