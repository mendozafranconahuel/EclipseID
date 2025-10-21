package punto3;

// Una interfaz extiende a otras interfaces para heredar sus métodos
public interface OperacionesBancarias extends OperacionesComunes, OperacionesImportantes {
	// Puedes añadir más constantes y métodos abstractos aquí
	double saldo = 0.0; 
    
	void depositar(double monto);
		
	void consultarSaldo();
}