package mrOlimpia;

public class Aspirante extends Thread {
	private int nroAspirante;
	private MrOlimpia m = new MrOlimpia();

	public Aspirante(int nroAspirante) {
		this.nroAspirante = nroAspirante;
	}

	@Override
	public void run() {
		m.pista1(nroAspirante);
		m.pista2(nroAspirante);
		System.out.println("aspirante " + nroAspirante + "Termino la sesion");
	}

}
