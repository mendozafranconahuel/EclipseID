package punto1;

public class Tareas {
	double a = 0, b = 0;
	
	public static double tarea1(double calcular, String tipo) {
		switch (tipo) {
			case "a": calcular = calcular + 100;
				break;
			case "b": calcular = calcular - 100;
				break;
		}
		
	return calcular;
	}
	
	public static double tarea2(double calcular, String tipo) {
		switch (tipo) {
			case "a": calcular = 1.21 * calcular;
				break;
			case "b": calcular = calcular*0.5;
				break;
		}
		
	return calcular;
	}	
}