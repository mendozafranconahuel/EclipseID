package PARCIAL2023.PUNTO2;

import metodos.Metodo;

/*
La imagen de abajo muestra la disposición de una circulo de entrenamiento para los
futuros aspirantes a “Mr. Olympia”. 

El circuito posee 2 pistas, en cada una de ellas existen diversos 
aparatos de musculación que pueden ser usados sin ningún 
control por parte de los aspirantes. 

Las pistas son diferentes en tamaño y en la cantidad y tipo de aparatos. 

Dicho circuito posee las siguientes características: 

la Pista 1 solo admite a 20 reclutas al mismo tiempo, 
una vez que un aspirante estuvo el tiempo suficiente (1100 - 1300ms), 

Abandona la Pista 1 y si dirige por el pasillo que unan ambas pistas para entrar a la Pista 2, 
este pasillo puede albergar un sin número de aspirantes. 

La Pista 2 solo admite 10 reclutas, con lo cual, si no hay espacio, 
los ingresantes deben esperar en el pasillo. 

Una vez que el recluta pasa el tiempo suficiente en la Pista 2 (600-800ms), 
el circuito de entrenamiento finaliza.

Los 200 aspirantes estan todos reunidos en el Ingreso esperando tener lugar para
ingresar al circuito a medida que exista disponibilidad. 

Se debe mostrar el número de recluta que ingresa a cada pista, 
cuando sale de cada pista, cuando ingresa el pasillo y 
cuando finaliza la sesión de entrenamiento 
*/

import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {
        int numAspirantes = Metodo.pedirEntero(" > NUM ASPIRANTES:");

        Semaphore pista1 = new Semaphore(20);
        Semaphore pista2 = new Semaphore(10);
        Pasillo pasillo = new Pasillo();
        
        System.out.println("\n INGRESO AL RECINTO: ");
        for (int i = 1; i <= numAspirantes; i++) {
            Aspirante aspirante = new Aspirante(i, pista1, pista2, pasillo);
            aspirante.start();
        }
        try {
        	//aspirante.join();
        }catch (Exception e) {
			e.printStackTrace();
        }
    }
}
