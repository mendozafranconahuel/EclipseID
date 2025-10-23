package aeropuerto;

public class Pasajero extends Thread {
	private Aeropuerto m;
	private int idPasajero;
	private int terminal;

	public Pasajero(int idPasajero, int terminal) {
		this.idPasajero = idPasajero;
		this.m = new Aeropuerto();
		this.terminal = terminal;
	}

	@Override
	public void run() {
		try {
			m.checkIn(idPasajero, terminal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
