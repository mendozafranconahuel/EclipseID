package punto3;

public class Pasillo {
	private int pasillo;

	public Pasillo(int pasillo) {
		super();
		this.pasillo = pasillo;
		
	}
	
	// false = listo para entrar
	// true = ocupado
	
	public void cambiarEstado() throws InterruptedException{
		if (this.pasillo==0) {
			this.pasillo=1;
		}else {
			this.pasillo=0;
		}
	}

	public synchronized int getPasillo() {
		return pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}
	
	
	

}