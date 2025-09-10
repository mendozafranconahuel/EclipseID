package punto2;

public class Colorear {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";  // Incrementador
    public static final String ROJO = "\u001B[31m";  // Decrementador
    public static final String VERDE = "\u001B[32m"; // Resultado final
    
    // Métodos para obtener el color formateado
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