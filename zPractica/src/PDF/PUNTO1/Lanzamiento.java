package PDF.PUNTO1;

import metodos.Metodo;

public class Lanzamiento extends Thread {
    private int idDado;
    private int valor;
    
    public Lanzamiento(int idDado) {
        this.idDado = idDado;
    }
    
    public int getValor() {
        return valor;
    }
    
    public int getIdDado() {
        return idDado;
    }
    
    @Override
    public void run() {        // Simular lanzamiento de dado
        this.valor = Metodo.generarEntero(1, 6);
        System.out.println(" > DADO "+idDado+": "+valor);
    }
}