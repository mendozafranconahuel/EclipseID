package punto3;

public interface OperacionesComunes {
	// Atributos en interfaces son implícitamente public static final (constantes)
	double saldo = 0.0; 
	String alias = "alias_default";
	String banco = "Banco Global";
	
	// Los métodos deben ser abstractos (sin cuerpo) por defecto.
	void pagarServicio(String servicio, double monto);
	
	void cambiarAlias(String nuevoAlias);
}