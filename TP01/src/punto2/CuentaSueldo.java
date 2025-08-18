package punto2;
import punto1.CuentaBancaria;

public class CuentaSueldo extends CuentaBancaria{ //HIJO
	 int legajo = 0;
	 String institución, beneficios;
	 long cbu;
	 double tope;
	 
//CONSTRUCTORES
	 public CuentaSueldo(){
		super();
		this.legajo = 0;
		this.institución = "Desconocido";
		this.beneficios = "Desconocido";
		this.cbu = 0;
		this.tope = 0;
	 }
// SE PUEDE EDITAR
	 public CuentaSueldo(
		long dni, double saldo, double interes, 
		int legajo, String institución, String beneficios, long cbu, double tope) {
			this.dni = dni;
			this.saldo = saldo;
			this.interes = interes;
			this.legajo = legajo;
			this.institución = institución;
			this.beneficios = beneficios;
			
			if(funcion.validarLong(cbu) == 6){
				this.cbu = cbu;
			}	
			else {
				System.out.println(" - CORRIGA EL CBU");
			}

			if(tope < 15000){
				this.tope = tope;
				//System.out.println("Carga Finalizada");
			}
			else {
				System.out.println(" - CORRIGA EL EL TOPE, DEBE SER MENOR A 15000");
			}
	}
/*	 public static void mostrar() { //CORREGIR EL PORQUE
		System.out.println("- DNI: "+dni);
		System.out.println("- SALDO: "+saldo);
		System.out.println("- INTERES: "+interes+"\n");
	}*/
	 
}//CuentaSueldo
