package PARCIAL2023.PUNTO1;
import metodos.Metodo;
import java.util.concurrent.Semaphore;

/*
Se tienen 3 procesos/HILOS concurrentes A, B, C, 
cada proceso lo unico que hace es escribir la letra del nombre del proceso 
de forma indefinida, es decir, el proceso A 
escribe “A”, el proceso B escribe “B” y el proceso C escribe “C”. 

Sincronice unicamente empleando semáforos los 3 procesos, para:
a. Escribir la siguiente secuencia: ABCABCABCABCABC.
b. Escribir la siguiente secuencia: BCABCABCABCABCABCA.

*/

public class incisoB {
	
	public static void orden(String letra) {
		
	}
	
	public static void main(String[] args) {
		int repeticiones = Metodo.pedirEntero("\n > CANTIDAD DE REPETICIONES: ");
		
        Semaphore semA = new Semaphore(0); // A comienza
        Semaphore semB = new Semaphore(1);
        Semaphore semC = new Semaphore(0);
		
		Proceso procesoA = new Proceso("A", repeticiones, semA, semB);
        Proceso procesoB = new Proceso("B", repeticiones, semB, semC);
        Proceso procesoC = new Proceso("C", repeticiones, semC, semA);
		
        procesoA.start();
        procesoB.start();
        procesoC.start();
        System.out.print("\n > SECUENCIA:\t");
		try {
			procesoA.join();
			procesoB.join();
			procesoC.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}// main
}// class
