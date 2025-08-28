package punto2;
import punto1.CuentaBancaria;
import metodos.Metodo;

public class CuentaSueldo extends CuentaBancaria{ //HIJO
	 int legajo = 0;
	 String institucion, beneficios;
	 long cbu;
	 double tope;
	 
//Constructor por defecto y constructor con CBU (el cual es un número de 18 dígitos) y tope fijado en 15.000

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
			this.saldo = Metodo.redondear(saldo, 2);
			this.interes = interes;
			this.legajo = legajo;
			this.institucion = institucion;
			this.beneficios = beneficios;
			
			if(Metodo.validarLong(cbu) == 18){ //MODIFICAR A 18
				this.cbu = cbu;
			}	
			else {
				System.out.println(" CORRIGA EL CBU");
			}

			if(tope <= 15000){
				this.tope = tope;
				System.out.println("- CARGA EXITOSA");
			}
			else {
				System.out.println("- CORRIGA EL EL TOPE, DEBE SER MENOR A 15000");
			}
	}

	public int getLegajo() {
		return legajo;
	}

	 public void setLegajo(int legajo) {
		 this.legajo = legajo;
	 }

	 public String getInstitucion() {
		 return institucion;
	 }

	 public void setInstitucion(String institucion) {
		 this.institucion = institucion;
	 }

	 public String getBeneficios() {
		 return beneficios;
	 }

	 public void setBeneficios(String beneficios) {
		 this.beneficios = beneficios;
	 }

	 public long getCbu() {
		 return cbu;
	 }

	 public void setCbu(long cbu) {
		 this.cbu = cbu;
	 }

	 public double getTope() {
		 return tope;
	 }

	 public void setTope(double tope) {
		 this.tope = tope;
	 }
	 
// -------------------------------------------------------------------------------------------------//

	public void mostrarSueldo() { //CORREGIR EL PORQUE
		System.out.println("- DNI: "+dni);
		System.out.println("- LEGAJO: "+legajo);
		System.out.println("- INSTITUCION: "+institucion);
		System.out.println("- BENEFICIO: "+beneficios);
		System.out.println("- SALDO: "+saldo);
		System.out.println("- INTERES: "+interes+"\n");
	}

//Sobrescribir el método retirar (double), para que además de permitir sacar una cantidad de la cuenta (si hay saldo), no permita extracciones superiores al tope.
	
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
	
//transferir (monto, CBU): este método simulará una transferencia a otra cuenta por el monto ingresado (siempre y cuando haya saldo) y decrementará el saldo de la cuenta. Para la “transferencia”, muestre el saldo final de la cuenta.
	
	public void trasferir(double monto,long cbu) {
		monto = Metodo.redondear(monto, 2);
		if(this.saldo >= monto && Metodo.validarLong(cbu) == 18) { //cambiar por 18
			this.saldo = saldo - monto;
			System.out.println("\n - TRASFERENCIA HECHA DE: $"+monto+" A "+cbu);
			System.out.println(" - SALDO ACTUAL:"+this.saldo);
		}
		else {System.out.println(" * NO ES POSIBLE REALIZAR LA TRANSFERENCIA");}
	}

//Sobrecargue el método transferir (monto, Alias) de la clase CuentaSueldo para que acepte un alias alfanumérico.
	
	public void trasferir(double monto,String alias) {
		monto = Metodo.redondear(monto, 2);
		if(this.saldo >= monto) {
			this.saldo = saldo - monto;
			System.out.println("\n- TRASFERENCIA HECHA DE: $"+monto+" A "+alias);
			System.out.println("\n- SALDO ACTUAL:"+this.saldo);
		}
		else {System.out.println(" NO ES POSIBLE REALIZAR LA TRANSFERENCIA");}
	}
}//CuentaSueldo
