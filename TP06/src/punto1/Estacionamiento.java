package punto1;

import java.util.concurrent.Semaphore;

public  class Estacionamiento {
	
	private final int capacidad= 20;
	private Semaphore estacionamiento = new Semaphore(capacidad);
	private Semaphore entradaUno = new Semaphore(1);
	private Semaphore entradaDos = new Semaphore(1);
	private Semaphore salidaUno = new Semaphore(1);
	private Semaphore salidaDos = new Semaphore(1);
 
	public void entrar(int numero) {
		try {
				estacionamiento.acquire();
				System.out.println("El auto "+ numero+" esta intentando entrar");
				if (entradaUno.tryAcquire()) {
					System.out.println("El auto " + numero + " esta entrando por la entrada uno");
					Thread.sleep(1500);
					entradaUno.release();
					System.out.println("La entrada uno ahora esta libre");
				} else {
					entradaDos.acquire();
					System.out.println("El auto " + numero + " está entrando por la entrada dos");
					Thread.sleep(1500);
					entradaDos.release();
					System.out.println("La entrada dos ahora esta libre");
				} 			     
			} catch (InterruptedException e) {
		            e.printStackTrace();
			}
		
	}
	
	public void salir(int num) {
		try {
			System.out.println("El auto "+ num +" esta intentando salir");
			if (salidaUno.tryAcquire()) {
				System.out.println("El auto " + num + " esta saliendo por la salida uno");
	            Thread.sleep(1500);
	            salidaUno.release();
	            System.out.println("La salida uno ahora esta libre");
	        } else {
	        	salidaDos.acquire();
	        	System.out.println("El auto " + num + " esta saliendo por la salida dos");
	            Thread.sleep(1500);
	            salidaDos.release();
	            System.out.println("La salida dos ahora esta libre");
	        } 

			 
	            
		} catch (InterruptedException e) {
			e.printStackTrace();
	    }
		estacionamiento.release();
	}
}