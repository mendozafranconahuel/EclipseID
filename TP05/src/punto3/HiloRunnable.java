package punto3;

public class HiloRunnable implements Runnable {
	
	private Tarea tarea;
		public HiloRunnable(Tarea tarea) {
			this.tarea=tarea;
		}  		
	@Override
		public void run() {
			tarea.mostrar();
		}
        
}