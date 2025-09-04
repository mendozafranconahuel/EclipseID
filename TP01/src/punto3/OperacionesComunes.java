package punto3;

public interface OperacionesComunes {
	String moneda = "ARS";
	Integer codigoBanco = 123; //123
	double comision = 0.05; //5%
	public void pagarServicio();
	public void cambiarAlias();
}
