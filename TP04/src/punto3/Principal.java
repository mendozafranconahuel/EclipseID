package punto3;

public class Principal {
	
	public static void main(String[] args) {
		
		Pasillo pasillo = new Pasillo(0);
		PersonaHilo [] personas = new PersonaHilo[10];
		
		 for (int i = 0; i < personas.length; i++) {
			personas[i] = new PersonaHilo(pasillo,i);
		}
		 for (int i = 0; i < personas.length; i++) {
				personas[i].start();
				 try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			} 
	}
	
}