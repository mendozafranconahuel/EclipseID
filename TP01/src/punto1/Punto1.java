package punto1;
import metodos.Metodo;
public class Punto1 {
	
	public static int menu(){
		int opcion = 0;
		System.out.println("\n\t -- MENU PUNTO 1 --");
		System.out.println("\t 1. MOSTRAR CUENTA.");
		System.out.println("\t 2. ACTUALIZAR SALDO.");
		System.out.println("\t 3. INGRESAR .");
		System.out.println("\t 4. RETIRAR.");
		System.out.println("\t 5. SALIR");
		opcion = Metodo.validarOpcion(5);
		
	return opcion; 
	}
		
	
	public static void main(String[] arg) {
		long dni = Metodo.pedirLong("> INGRESE DNI: ");
		double sueldo = Metodo.pedirDoublePositivo("> INGRESE EL SUELDO: ");
		double interes = Metodo.pedirDoublePositivo("> INGRESE EL INTERES: ");
			CuentaBancaria cliente = new CuentaBancaria(dni, sueldo, interes);

		int opcion = 0;
		while(opcion != 5) {
			opcion = menu();
			switch (opcion) {
				case 1: System.out.println("\n - MOSTRAR CUENTA");
						cliente.mostrarCuenta();
					break;
				case 2: System.out.println("\n - ACTUALIZAR SUELDO DE CUENTA");
						cliente.actulizarSaldo();
					break;	
				case 3: System.out.println("\n - INGRESAR MONTO A LA CUENTA");
						double monto = Metodo.pedirDoublePositivo(" > MONTO: ");
						cliente.ingresar(monto);
					break;
				case 4: System.out.println("\n - INGRESAR MONTO A RETIRAR DE LA CUENTA");
						double retiro = Metodo.pedirDoublePositivo(" > MONTO: ");
						cliente.retirar(retiro);
					break;
			}
		}
	System.out.println("\nA FINALIZADO EL PROGRAMA.");
	}
}