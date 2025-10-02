package punto3;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated met
		 String noticias[]= {"https://eltribunodejujuy.com/policiales/2025-10-2-2-39-0-detienen-a-un-profugo-con-orden-de-captura-vigente",
				"https://eltribunodejujuy.com/policiales/2025-10-2-2-29-0-intento-alquilar-y-la-estafaron-en-558-mil",
				"https://eltribunodejujuy.com/policiales/2025-10-2-2-27-0-robaron-90-millones-que-estaban-en-un-automovil", 
				"https://eltribunodejujuy.com/policiales/2025-10-2-2-24-0-la-novia-de-pequeno-j-fue-quien-lo-delato",
				"https://eltribunodejujuy.com/policiales/2025-10-2-0-0-0-camion-que-derramo-ripio-ocasiono-un-siniestro-vial",
				"https://eltribunodejujuy.com/policiales/2025-10-2-0-0-0-disparos-corridas-y-detenciones-en-la-feria-de-monterrico",
				"https://eltribunodejujuy.com/policiales/2025-10-1-22-47-0-el-enfermero-que-quiso-matar-a-un-bebe-es-sometido-a-juicio",
				"https://eltribunodejujuy.com/informacion-general/2025-10-1-18-0-0-comenzo-el-juicio-al-enfermero-que-suministro-leche-por-via-endovenosa-a-un-bebe",
				"https://eltribunodejujuy.com/policiales/2025-10-1-0-0-0-con-un-supuesto-concurso-trajo-a-tres-jovenes-a-jujuy",
				"https://eltribunodejujuy.com/policiales/2025-9-30-23-10-0-salvados-de-milagro-luego-de-desbarrancar-60-metros"};
	    
		 // Se crea una instancia de Tarea
		 for(int i=0;i<noticias.length;i++) {
			 Tarea tarea = new Tarea(noticias, i);
			 HiloRunnable hilo = new HiloRunnable(tarea);

			 // Se ejecuta el hilo
			 new Thread(hilo).start();
			}	
	}
}
