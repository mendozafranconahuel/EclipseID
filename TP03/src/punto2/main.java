package punto2;

public class main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        hiloContador hilo1 = new hiloContador(1, contador);
        hiloContador hilo2 = new hiloContador(2, contador);

        hilo1.start();
        hilo2.start();
        
        //muestra en consola cómo un hilo incrementa 100 veces el objeto contador
        //y luego otro hilo lo incrementa de nuevo 100 veces. No se intercalan
       
    }
}
