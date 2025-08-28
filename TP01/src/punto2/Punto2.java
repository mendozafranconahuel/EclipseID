package punto2;
import metodos.Metodo;

public class Punto2 {
	public static int menu(){
		int opcion = 0;
		System.out.println("\n\n\t -- MENU PUNTO 1 --");
		System.out.println("\t 1. MOSTRAR CUENTA.");
		System.out.println("\t 2. RETIRAR.");
		System.out.println("\t 3. TRANSFERIR CBU.");
		System.out.println("\t 4. TRANSFERIR ALIAS");
		System.out.println("\t 5. SALIR");
		opcion = Metodo.validarOpcion(5);
		
	return opcion; 
	}
		
	public static void main(String[] arg) {
		CuentaSueldo negocio = new CuentaSueldo(11111111, 0, 10,1,"Negocio","CuentaSueldo", 123456789987654321L, 15000);
		
		long dni = Metodo.pedirLong("> INGRESE DNI: ");
		double saldo = Metodo.pedirDouble("> INGRESE EL SALDO: ");
		double interes = Metodo.pedirDouble("> INGRESE EL INTERES: ");
		int legajo = Metodo.pedirEntero("> INGRESE LEGAJO: ");
		String institucion = Metodo.cadena("> INGRESE INSTITUCION: ");
		String beneficios = Metodo.cadena("> INGRESE BENEFICIOS: ");
		long cbu = Metodo.pedirLong("> INGRESE CBU: ");
		double tope = Metodo.pedirDouble("> INGRESE TOPE: ");

		CuentaSueldo cliente = new CuentaSueldo(dni, saldo, interes,legajo,institucion,beneficios, cbu,tope);
			
		int opcion = 0;
		while(opcion != 5) {
			opcion = menu();
			switch (opcion) {
				case 1: System.out.println("\n - MOSTRAR CUENTA");
						cliente.mostrarCuenta();
					break;
					
				case 2: System.out.println("\n - EXTRAER DINERO DE LA CUENTA");
						double retiro = Metodo.pedirDouble(" > MONTO: ");
							cliente.retirar(retiro);
					break;
					
				case 3: System.out.println("\n - TRANSFERIR DINERO POR CBU");
						double montoT = Metodo.pedirDouble(" > MONTO: ");
						long cbuT = Metodo.pedirLong("> INGRESE CBU");
							cliente.trasferirCBU(montoT, cbuT);
					break;
					
				case 4: System.out.println("\n - TRANSFERIR DINERO POR CBU");
						double montoA = Metodo.pedirDouble(" > MONTO: ");
						String alias = Metodo.cadena("> ALIAS: ");
							cliente.trasferirAlias(montoA, alias);
					break;
			}
		}
	System.out.println("A FINALIZADO EL PROGRAMA.");
	}
}
