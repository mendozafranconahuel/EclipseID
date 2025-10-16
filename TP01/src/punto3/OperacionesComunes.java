package punto3;
/*
Cree   una   interfaz   llamada   
OperacionesComunes   con   3   atributos   y   

2   métodos (pagarServicio() y cambiarAlias()). 

*/

public interface OperacionesComunes {
	float saldo;
	String monto;
	String alias;
	String servicio
	
	public void pagarServicio(String servicio, float monto) {
		if (monto > 0 && monto <= saldo) {
			saldo -= monto;
			pago = servicio;
			System.out.println("Pago de " + servicio + " por un monto de " + monto + " realizado con éxito.");
		} 
		else {
			System.out.println("Saldo insuficiente o monto inválido.");
		}
	}//pagarServicio
	
	public void cambiarAlias(String nuevoAlias) {
		if (nuevoAlias != null && !nuevoAlias.isEmpty()) {
			alias = nuevoAlias;
			System.out.println("Alias cambiado a: " + alias);
		} 
		else {
			System.out.println("Alias inválido.");
		}
	}//cambiarAlias
}
