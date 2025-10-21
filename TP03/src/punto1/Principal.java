package punto1;

/*
Implemente lo siguiente:
a. Una clase que imprima el siguiente patrón de sucesión de X: “0X1X2X3X…” (iXpara i=0……99), 
a continuación debe imprimir un patrón de sucesión de Y: “0Y1Y2Y3Y….” (iY para i=0……99).

b. Mediante Hilos heredando de Thread, emplee dos clases para realizar dicha
impresión de forma concurrente. Repita el proceso 10 veces para observar cómo
se imprimen los distintos lanzamientos.

c. Obtenga la porción de la fila que posea la sucesión más larga de cualquier letra.
Imprima toda la sucesión.

d. Si en el inciso b) no se imprimen correctamente utilice una pausa o join.

e. Razone y comente los resultados obtenidos. 
 
*/
public class Principal {
	public static void main(String[] args) {
		
		Impresion hiloX = new Impresion("X","AZUL");
			hiloX.start(); //Inicia el hilo X

		Impresion hiloY = new Impresion("Y","ROJO");
			hiloY.start(); //Inicia el hilo Y
		
		try {
			hiloX.join(); //Espera a que el hilo X termine antes de continuar
			hiloY.join(); //Espera a que el hilo Y termine antes de continuar
		} catch (InterruptedException e) {
			System.out.println("Hilo interrumpido");
			e.printStackTrace();
		}
	}
}
