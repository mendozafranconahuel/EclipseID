package punto2;

public class Punto2 {
    public static void main(String[] args) {
        Contador contador = new Contador();

        HiloIncrementador hiloIncrementador = new HiloIncrementador(contador);
        HiloDecrementador hiloDecrementador = new HiloDecrementador(contador);

        hiloIncrementador.start();
        hiloDecrementador.start();

        try {
            hiloIncrementador.join();
            hiloDecrementador.join();
        } 
        catch (InterruptedException e) {e.printStackTrace();}

        System.out.println("\n\n - Valor final del contador: " + contador.getContador());
    }
}