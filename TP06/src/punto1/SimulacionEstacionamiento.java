package punto1;

public class SimulacionEstacionamiento {
	
	public static void main(String[] args) {
		Estacionamiento estacionamiento= new Estacionamiento();
		for (int i=0;i<20;i++) {
			new Auto(i+1, estacionamiento).start();
		}
	}
}


