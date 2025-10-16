package punto4;

public class ProcesoS extends Thread {
	private Monitor m;

	public ProcesoS(Monitor m) {
		this.m = m;
	}

	@Override
	public void run() {
		try {
			int tiempo = m.tiempoEjecucion();
			System.out.println("ProcesoS -> ejecutando s1  : tiempo estimado " + tiempo);
			sleep(tiempo * 1000);
			m.esperar();
			System.out.println("ProcesoS -> ejecutando s2 : tiempo estimado " + tiempo);
			sleep(tiempo * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
