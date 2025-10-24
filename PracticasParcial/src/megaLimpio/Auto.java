package megaLimpio;

public class Auto extends Thread {
	private String idAuto;
	private Lavadero m = new Lavadero();;

	public Auto(int idAuto) {
		this.idAuto = "Auto " + idAuto;
	}

	@Override
	public void run() {
		m.ingresarGalpon(idAuto);
		m.lavar(idAuto);
	}

}
