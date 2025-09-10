package punto3;

/*
Sobre el inciso anterior agregue un retardo aleatorio entre 50-150ms y observe los
resultados. NOTA: para los puntos 2 y 3 pruebe realizando una pausa o empleando el
método .join 
*/

import punto2.Contador;

public class Punto3 {
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
        catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n\n - Valor final del contador: " + contador.getContador());
    }
}