package punto2;

public class main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        hiloContador hilo1 = new hiloContador(1, contador);
        hiloContador hilo2 = new hiloContador(2, contador);

        hilo1.start();
        hilo2.start();
        
        
       
    }
}
