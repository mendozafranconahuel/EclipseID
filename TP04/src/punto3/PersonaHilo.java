package punto3;

import java.util.Random;


public class PersonaHilo extends Thread{
	
	static Random random = new Random();
	private Pasillo estadoPasillo;
	private int id;
	
	public PersonaHilo(Pasillo estadoPasillo,int id) {
		super();
		this.estadoPasillo=estadoPasillo;
		this.id= id;
	}

	public void run() {
		try {
			System.out.println("La persona " + this.id + " está por entrar al Zoológico");
			Thread.sleep(random.nextInt(100, 201));
			
			while (true) {
			
			        if (estadoPasillo.getPasillo()==1) {
			        	synchronized (estadoPasillo) {
			        		System.out.println("La persona " + this.id + " está haciendo fila para ingresar");
				            estadoPasillo.wait();
						}
			            
			        } else {
			        	synchronized (estadoPasillo) {
			        		estadoPasillo.cambiarEstado();
			        		System.out.println("La persona " + this.id + " está entrando al Zoológico");
			        	}
			        	Thread.sleep(50);
			        	synchronized (estadoPasillo) {
			        		System.out.println("La persona " + this.id + " entró al Zoológico");
				            estadoPasillo.cambiarEstado();  
				            estadoPasillo.notify();  }
				            break;  
						}
			        	
			        }
			    
			sleep(random.nextInt(400, 701));
			System.out.println("La persona " + this.id + " esta por salir del Zoológico");
			
			while (true) {
		        if (estadoPasillo.getPasillo()==1) {
		        	synchronized (estadoPasillo) {
		        		System.out.println("La persona " + this.id + " está haciendo fila para salir");
			            estadoPasillo.wait();
					}
		        } else {
		        	synchronized (estadoPasillo) {
		        		estadoPasillo.cambiarEstado();
		        		System.out.println("La persona " + this.id + " está saliendo del Zoológico");
		        	}
		        	Thread.sleep(50); 
		        	synchronized (estadoPasillo) {
		        		System.out.println("La persona " + this.id + " salió del Zoológico");
			            estadoPasillo.cambiarEstado();  
			            estadoPasillo.notify();  }
			            break;  
					}
		        	
		        }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
