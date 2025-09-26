package punto2;

public class Punto2 {

	public static void main(String[] args) {
		
		Mostrador panaderia = new Mostrador();
		ProductorBizcocho pb = new ProductorBizcocho(panaderia);
		ProductorFactura pf = new ProductorFactura(panaderia);
		GeneradorClientes gc = new GeneradorClientes(panaderia);
		
		pb.start();
		pf.start();
		gc.start();
		
	}

}
