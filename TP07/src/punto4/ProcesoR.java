package punto4;

public class ProcesoR extends Thread {
	private Monitor m;

	public ProcesoR(Monitor m) {
		this.m = m;
	}

	@Override
	public void run() {
		try {
			int tiempo = m.tiempoEjecucion();
			System.out.println("ProcesoR -> ejecutando r1 : tiempo estimado " + tiempo);
			sleep(tiempo * 1000);
			System.out.println("ProcesoR -> termino de ejecutar r1");
			m.indicar();
			System.out.println("ProcesoR -> ejecutando r2 : tiempo estimado " + tiempo);
			sleep(tiempo * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
