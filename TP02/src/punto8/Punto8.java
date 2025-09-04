package punto8;
import metodos.Metodo;
public class Punto8 {
    public static void main(String[] args) {
        
        int numSillas = Metodo.pedirEntero(" > NUMERO DE SILLAS DE LA BARBERIA: ");
        int numClientes = Metodo.pedirEntero(" > ESTABLESCA EL NUMERO DE CLIENTES: ");
        System.out.println("\n\n\n - BARBERIA CON "+numSillas+": ATIENDE A "+numClientes+" CLIENTES.\n\n\n");
        Barberia barberia = new Barberia(numSillas);

        Barberia.Barbero barbero = barberia.crearBarbero();
        barbero.start();

        //genera clientes
        for (int i = 1; i <= numClientes; i++) {
            Barberia.Cliente cliente = barberia.crearCliente(i);
            cliente.start();

            try {
                Thread.sleep((int)(Math.random() * 1500)); // llegada aleatoria
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
