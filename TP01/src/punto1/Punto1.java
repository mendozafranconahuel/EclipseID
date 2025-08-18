package punto1;

public class Punto1 {
	public static void main(String[]Arg) {
		CuentaBancaria cliente1 = new CuentaBancaria(41, 100000, 40);
		CuentaBancaria cliente2 = new CuentaBancaria(42, 200000, 30);
		CuentaBancaria cliente3 = new CuentaBancaria(43, 300000, 20);
		CuentaBancaria cliente4 = new CuentaBancaria(44, 400000, 20);
		
		cliente1.mostrarCuenta();
		cliente2.actulizarSaldo();
		cliente4.ingresar(50000.3333);
		cliente3.retirar(500000.3333);
		
	}
}