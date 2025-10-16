package Punto5PC;

public class Principal {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Persona per = new Persona(i+1);
			per.start();	
		}
	}
}