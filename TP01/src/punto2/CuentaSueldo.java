package punto2;
import punto1.CuentaBancaria;
import metodos.Metodo;

public class CuentaSueldo extends CuentaBancaria{ //HIJO
	 int legajo = 0;
	 String institucion, beneficios;
	 long cbu;
	 double tope;
	 
//CONSTRUCTORES
	 public CuentaSueldo(){ //POR DEFECTO
		super();
		this.legajo = 0;
		this.institucion = "Desconocido";
		this.beneficios = "Desconocido";
		this.cbu = 0;
		this.tope = 0;
	 }

	 public CuentaSueldo(
		long dni, double saldo, double interes, 
		int legajo, String institucion, String beneficios, long cbu, double tope) {
			this.dni = dni;
			this.saldo = saldo;
			this.interes = interes;
			this.legajo = legajo;
			this.institucion = institucion;
			this.beneficios = beneficios;
			
			if(Metodo.validarLong(cbu) == 6){ //MODIFICAR A 18
				this.cbu = cbu;
			}	
			else {
				System.out.println(" CORRIGA EL CBU");
			}

			if(tope < 15000){
				this.tope = tope;
				System.out.println("- CARGA EXITOSA");
			}
			else {
				System.out.println("- CORRIGA EL EL TOPE, DEBE SER MENOR A 15000");
			}
	}
// -------------------------------------------------------------------------------------------------//
	 
	public void mostrar() { //CORREGIR EL PORQUE
		System.out.println("- DNI: "+dni);
		System.out.println("- LEGAJO: "+legajo);
		System.out.println("- INSTITUCION: "+institucion);
		System.out.println("- BENEFICIO: "+beneficios);
		System.out.println("- SALDO: "+saldo);
		System.out.println("- INTERES: "+interes+"\n");
	}
// -------------------------------------------------------------------------------------------------//

	public void retirar(double extraer) {
		if (this.saldo > 0){
			//double extraer = pedir.pedirDouble("> INGRESE EL MONTO A EXTRAER: ");
			extraer = Metodo.redondear(extraer, 2);
			if (extraer <= this.saldo && extraer <= this.tope) {
				this.saldo = this.saldo - extraer;
				mostrarCuenta();
			}
			else {System.out.println(" NO ES POSIBLE EXTRAER. USUARIO: "+this.dni+".");}
		}
		else {System.out.println(" EL USUARIO "+this.dni+" NO TIENEN FONDOS PARA EXTRAER.");}
	}
// -------------------------------------------------------------------------------------------------//
	
	public void trasferirCBU(double monto,long cbu) {
		
		if(this.saldo >= monto || Metodo.validarLong(cbu) == 6) { //cambiar por 18
			this.saldo = saldo - monto;
			System.out.println("\n- SALDO ACTUAL:"+this.saldo);
		}
		else {System.out.println(" NO ES POSIBLE REALIZAR LA TRANSFERENCIA");}
	}
// -------------------------------------------------------------------------------------------------//

	public void trasferirAlias(double monto,String alias) {
		if(this.saldo >= monto) {
			//Metodo.validarLong(cbu);
			this.saldo = saldo - monto;
			System.out.println("\n- TRASFERENCIA HECHA DE: $"+monto+" A "+alias);
			System.out.println("\n- SALDO ACTUAL:"+this.saldo);
		}
		else {System.out.println(" NO ES POSIBLE REALIZAR LA TRANSFERENCIA");}
	}
// -------------------------------------------------------------------------------------------------//
}//CuentaSueldo
