package punto2;

public class Colorear {
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";  
    public static final String ROJO = "\u001B[31m";  
    public static final String VERDE = "\u001B[32m"; 
    
    public static String azul(String texto) {
        return AZUL + texto + RESET;
    }
    
    public static String rojo(String texto) {
        return ROJO + texto + RESET;
    }
    
    public static String verde(String texto) {
        return VERDE + texto + RESET;
    }
}