package punto2;

public class Estacionamiento {
	private int capacidadMax;
    private int autosDentro = 0;

    public Estacionamiento(int capacidad) {
        this.capacidadMax = capacidad;
    }

    public synchronized void entrar(int idAuto) throws InterruptedException  {
        System.out.println("Auto " + idAuto + " intentando entrar...");
        while (autosDentro >= capacidadMax) {
            System.out.println("El Auto " + idAuto + " esta esperando, el estacionamiento lleno.");
            wait(); // espera hasta que haya lugar
        }
        autosDentro++;
        String entrada = (Math.random() < 0.5) ? "Entrada 1" : "Entrada 2";
        System.out.println("El Auto " + idAuto + " entró por " + entrada + " | Espacios: " +autosDentro+"/"+capacidadMax);
    }

    public synchronized void salir(int idAuto) {
        autosDentro--;
        String salida = (Math.random() < 0.5) ? "Salida 1" : "Salida 2";
        System.out.println("El Auto " + idAuto + " salió por " + salida + " | Ocupados: " + autosDentro+"/"+capacidadMax);
        notifyAll(); // despierta a los autos que estaban esperando entrar
    }
}