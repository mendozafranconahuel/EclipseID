package punto5;

public class principal5 {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();

		/*
		//Forma secuencial
        for (int root = 1; root <= 20; root++) {
            double resultado = metodo.SumRootN(root);
            System.out.println("root = " + root + " => resultado = " + resultado);
        }
        */
		
		//Con hilos
		 hilo[] hilos = new hilo[20];

	        for (int root = 1; root <= 20; root++) {
	            hilos[root - 1] = new hilo(root);
	            hilos[root - 1].start();
	        }
	        
	        
	        for (int i = 0; i < 20; i++) {
	            try {
	                hilos[i].join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        
	        long fin = System.currentTimeMillis();
	        
	        System.out.println("Tiempo total de ejecución: "+(fin - inicio)+" ms");
	}

}
