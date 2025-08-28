package punto1; import metodos.Metodo;

public class CuentaBancaria {
	//long contador = 100001, 
	long numCuenta;
	protected long dni;
	// El número de cuenta se asignará de forma correlativa a partir de 100001, asignando el siguiente número al último asignado
	static int contador = 100001;
	protected double saldo;
	protected double interes;

//Constructor por defecto y constructor con DNI, saldo e interés. 
//CONSTRUCTORES
	public CuentaBancaria(){ //Por defecto
		this.numCuenta = this.contador;
		this.dni = 0;
		this.saldo = 0;
		this.interes = 0;
		this.contador = this.contador + 1;
	}
	public CuentaBancaria(long dni, double saldo, double interes){
		this.numCuenta = this.contador;
		this.dni = dni;
		this.saldo = Metodo.redondear(saldo, 2);
		this.interes = interes;
		this.contador = this.contador + 1;
	}
	
//METODOS
// actualizarSaldo(): actualizará el saldo de la cuenta aplicándole el interés diario (interés anual dividido entre 365 aplicado al saldo actual).
	public void actulizarSaldo(){
		double calculo;
		calculo = this.saldo * (this.interes/365);
		this.saldo += Metodo.redondear(calculo, 2);
		mostrarCuenta();
	}

	
// ingresar(double): permitirá ingresar una cantidad en la cuenta.

	public void ingresar(double monto){ //ingresar dinero al saldo actual
		//double monto = pedir.pedirDouble("> INGRESE EL MONTO A INGRESAR: ");
		this.saldo += Metodo.redondear(monto, 2);
		mostrarCuenta();
	}
// retirar(double): permitirá sacar una cantidad de la cuenta (si hay saldo).

	public void retirar(double extraer) {
		if (this.saldo > 0){
			//double extraer = pedir.pedirDouble("> INGRESE EL MONTO A EXTRAER: ");
			extraer = Metodo.redondear(extraer, 2);
			if (extraer <= this.saldo ) {
				this.saldo = this.saldo - extraer;
				mostrarCuenta();
			}
			else {System.out.println("- NO ES POSIBLE EXTRAER MAS QUE SU SALDO DE NUM CUENTA: "+this.numCuenta+".");}
		}
		else {System.out.println("- LA CUENTA"+this.numCuenta+"NO TIENEN FONDOS PARA EXTRAER.");}
	}
// Método que nos permita mostrar todos los datos de la cuenta.
	
	public void mostrarCuenta() {
		System.out.println("> NUM. CUENTA:"+numCuenta);
		System.out.println("- DNI: "+dni);
		System.out.println("- SALDO: "+saldo);
		System.out.println("- INTERES: "+interes+"\n");
	}
	
////////////////////////////////////////////////////////////////////////////	
	
}//Final