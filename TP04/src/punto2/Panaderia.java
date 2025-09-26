package punto2;
import metodos.Metodo;

public class Panaderia extends Thread {
	private int bizcochos = 0;
	private int facturas = 0;
	private int id_cliente = 0;
	private long tiempoHorneado = 0; 
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void mostrador(){
		System.out.println("\n > MOSTRADOR:");
		System.out.println(" - Bizcochos:"+bizcochos);
		System.out.println(" - Facturas:"+facturas+"\n");
	}
	
	public synchronized void hornearBizcocho() {
		try {
			tiempoHorneado = Metodo.generarLong(400, 600);
			System.out.println(" > Horneado de "+tiempoHorneado);
			Thread.sleep(tiempoHorneado);
		}
		catch (InterruptedException e){
			Thread.interrupted();
		}
		bizcochos++;
		System.out.println(" - Un Bizcocho disponible");
		mostrador();
		notify();
	}
	
	public synchronized void hornearFactura() {
		try {
			tiempoHorneado = Metodo.generarLong(1000, 1300);
			System.out.println(" > Horneado de "+tiempoHorneado);
			Thread.sleep(tiempoHorneado);
		}
		catch (InterruptedException e){
			Thread.interrupted();
		}
		facturas++;
		System.out.println(" - Una Factura disponible");
		mostrador();
		notify();
	}
	
	public synchronized void camprar(int id_cliente){
		try {
			while(bizcochos == 0 || facturas == 0) {
				System.out.println(" - CLIENTE ESPERANDO: ID: "+id_cliente);
				wait();
			}
		}
		catch(InterruptedException e) {
			Thread.interrupted();
		}
		bizcochos = bizcochos - 1;
		facturas = facturas - 1;
		System.out.println(" - COMPRA FINALIZADA POR EL CLIENTE "+id_cliente);
		mostrador();
	}
	
	public synchronized void salir(int id_cliente) {
		System.out.println(" > EL CLIENTE "+id_cliente+" SALIO.");
		setId_cliente(id_cliente+1);
	}
}

