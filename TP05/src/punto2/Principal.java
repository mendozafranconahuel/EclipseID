package punto2;

public class Principal {

	public static void main(String[] args) {
		Estacionamiento estacionamiento = new Estacionamiento(20);

        for (int i = 1; i <= 100; i++) {
            Thread auto = new Thread(new Auto(i, estacionamiento));
            auto.start();
            
            
            try {
                Thread.sleep(200);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            
        }
    }
}