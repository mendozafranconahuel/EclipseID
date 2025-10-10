package punto1;

public class Auto extends Thread{
	private int nro;
	private Estacionamiento estacionamiento;
	
	public Auto(int nro,Estacionamiento estacionamiento) {
		this.nro=nro;
		this.estacionamiento=estacionamiento;
	}
	
	@Override
	public void run() {
		try {
			estacionamiento.entrar(nro);
			Thread.sleep((long) (Math.random() * 3000 + 2000)); 
			estacionamiento.salir(nro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
