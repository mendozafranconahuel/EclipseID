package punto4;

public class Punto4 {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		ProcesoR r = new ProcesoR(m);
		ProcesoS s = new ProcesoS(m);

		r.start();
		s.start();
	}

}
