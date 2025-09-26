package punto2;

import metodos.Metodo;

/*Imagine el escenario de una panadería que produce Bizcochos y Facturas 
que son colocados en un mostrador, 

cada cliente se lleva un Bizcocho y una Factura, 
si los productos aún no están producidos, los clientes esperan. 

La producción de elementos y la compra son indefinidas 
(una panadería que trabaja las 24hs sin descansar recibiendo en todo momento clientes compradores). 

Además hay que destacar que los Bizcochos y Facturas se producen de a uno por vez, 
puesto que existen dos hornos muy pequeños y solo permiten la producción de un elemento 
de cada tipo en cualquier momento pero  simultáneamente. 

Simule la situación indicando en cada momento todo lo que sucede en la Panadería: 
	producción de un Bizcocho, 
	producción de una Factura, 
	cliente comprando,
	cliente esperando, 
	cliente retirándose del local 
	y mostrador vacío. 
	
Tenga en cuenta que el tiempo de producción de un Bizcocho es entre 400ms y 600ms, 
	el de una Factura es entre 1000ms y 1300ms, 
	y la llegada de los clientes se produce entre 800ms y 1500ms, 
	la compra y la retirada de los clientes del local demanda un tiempo entre 200ms y 400ms.

Debe identificar a cada cliente. */
public class Punto2 {
	public static void main(String[]args) {
		Panaderia panificadora = new Panaderia();
		
		Thread bizcochos = new Thread(()->{
			while(true) {
				panificadora.hornearBizcocho();
			}
		});
		
		Thread facturas = new Thread(()->{
			while(true) {
				panificadora.hornearFactura();
			}
		});
		
		bizcochos.start();
		facturas.start();
		
		while(true) {
			Cliente comprador = new Cliente(panificadora.getId_cliente(),panificadora);
			Thread compradores = new Thread();
			compradores.start();
			int esperaCliente = Metodo.generarEntero(800, 1500);
				try {
					Thread.sleep(esperaCliente);
					System.out.println(" - Clinte Esperando - ID: "+panificadora.getId_cliente());
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
