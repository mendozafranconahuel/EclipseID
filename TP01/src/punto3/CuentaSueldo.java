package punto3;

// La clase implementa la interfaz
public class CuentaSueldo implements OperacionesBancarias {
    
    // Variables de instancia para la clase
    private double saldoActual = OperacionesBancarias.saldo; // Inicializa con la constante de la interfaz
    private String aliasActual = OperacionesComunes.alias;
    
    // *** Implementación de OperacionesComunes ***
    @Override
    public void pagarServicio(String servicio, double monto) {
        if (this.saldoActual >= monto) {
            this.saldoActual -= monto;
            System.out.println("Pago de " + servicio + " por $" + monto + " realizado. Nuevo saldo: $" + this.saldoActual);
        } else {
            System.out.println("Saldo insuficiente para pagar " + servicio);
        }
    }

    @Override
    public void cambiarAlias(String nuevoAlias) {
        this.aliasActual = nuevoAlias;
        System.out.println("Alias cambiado exitosamente a: " + nuevoAlias);
    }
    
    // *** Implementación de OperacionesImportantes ***
    @Override
    public void transferenciaAltoMonto(double monto) {
        System.out.println("Alerta: Transferencia de alto monto ($" + monto + ") iniciada.");
        // Lógica de validación, seguridad, etc.
    }
    
    // *** Implementación de OperacionesBancarias (métodos propios) ***
    @Override
    public void depositar(double monto) {
        this.saldoActual += monto;
        System.out.println("Depósito de $" + monto + " realizado. Saldo actual: $" + this.saldoActual);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo actual de la cuenta (" + this.aliasActual + ") es: $" + this.saldoActual);
    }
}