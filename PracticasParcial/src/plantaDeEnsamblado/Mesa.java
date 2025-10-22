package plantaDeEnsamblado;

import java.util.concurrent.Semaphore;

public class Mesa extends Thread {
	private String mesa;
	private PlantaEnsamblado planta;
	private static Semaphore sem = new Semaphore(1);

	public Mesa(int nroMesa) {
		this.mesa = "mesa-" + nroMesa;
		this.planta = new PlantaEnsamblado();
	}

	@Override
	public void run() {
		boolean aux = true;
		while (true) {
			try {
				sem.acquire();
				aux = planta.emsamblar();
				sem.release();
			} catch (InterruptedException e) {
			}
			if (!aux) {
				planta.fase1(mesa);
				planta.fase2(mesa);
				planta.fase3(mesa);

			} else {
				break;
			}
		}
		System.out.println(mesa + " cerro porque no hay mas que hacer");
	}
}
