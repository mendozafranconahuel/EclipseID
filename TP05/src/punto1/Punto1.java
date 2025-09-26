package punto1;
import java.util.ArrayList;

import metodos.Metodo;
/*
Implemente, mediante Hilos heredando de Thread, 
el problema del Productor y Consumidor empleando una lista de elementos 
(para 10 procesos productores y 10 procesos consumidores). 

La lista tendrá el comportamiento de una cola, es decir, se manejará mediante el esquema FIFO. 

Los productores y consumidores serán lanzados de manera aleatoria, 
es esperable que ambos procesos posean velocidades distintas, 
para el caso de que los productores sean más lentos que los consumidores, 
provocará que los consumidores se encolen a la espera de elementos a consumir. 

En el caso contrario podría provocar que el contenedor de productos se llene. 
Los productores y consumidores serán lanzados a intervalos entre 100ms – 200ms.
*/
/*
a. Realice la implementación para una cola infinita. 
Teniendo en cuenta que un productor es más lento que un consumidor 
y demora en producir un nuevo elemento entre 1000ms y 1500ms, 
en cambio un consumidor demora en consumir un elemento entre 400ms y 800ms.

b. Realice la implementación para una cola de tamaño 5 que debe definir antes de
correr el programa. Si en un momento dado, la cantidad de elementos a producir
va a ser mayor a 5, el productor deberá esperar hasta que exista espacio, es decir,
hasta que algún elemento sea consumido. Para este caso los productores son más
rápidos que los consumidores. Un productor demora entre 400ms y 800ms para
producir un nuevo elemento, mientras que un consumidor demora entre 1000ms y
1500ms para consumir un elemento. Impleméntelo para un número infinito de
productores y consumidores.

c. Para ambos casos intercambie las velocidades de ambos procesos y comente los
resultados obtenidos. }*/

public class Punto1 {
	public static void main(String[]args) {
		System.out.println("\n - PRODUCTOR ");
			int minP = Metodo.pedirEntero("\t > MINIMO: ");
			int maxP = Metodo.pedirEntero("\t > MAXIMO: ");
			int tamP = Metodo.pedirEntero("\t > TAMAÑO: ");
		System.out.println("\n\n - CONSUMIDOR ");
			int minC = Metodo.pedirEntero("\t > MINIMO: ");
			int maxC = Metodo.pedirEntero("\t > MAXIMO: ");
			int tamC = Metodo.pedirEntero("\t > TAMAÑO: ");

		System.out.println("\n\n CARGA EXITOSA.\n\n");
		
		ArrayList<Integer> lista = new ArrayList<>();
		Productor producir = new Productor(lista,0);
		producir.start();
		
		for( int i = 0; i < 10; i++ ) {
			Consumidor consumir = new Consumidor(lista,i);
			consumir.start();
		}
	}
}
