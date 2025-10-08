package metodos;

public class Colorear {
    // --- Códigos de Control ---
    // El RESET es crucial para que el color no afecte el texto siguiente.
	
    public static final String RESET = "\u001B[0m";

    // --- Códigos de Primer Plano (Texto) ---
    
    // Estos códigos usan la secuencia 30m a 37m.
    
    public static final String NEGRO = "\t\u001B[30m";
    public static final String ROJO = "\t\u001B[31m";
    public static final String VERDE = "\t\u001B[32m";
    public static final String AMARILLO = "\t\u001B[33m";
    public static final String AZUL = "\t\u001B[34m";
    public static final String MAGENTA = "\t\u001B[35m";
    public static final String CYAN = "\t\u001B[36m";
    public static final String BLANCO = "\t\u001B[37m";

    // ------------------------------------------
    // --- MÉTODOS DE IMPRESIÓN DIRECTA (System.out.println) ---
    // ------------------------------------------

    public static void negro(String texto) {
        System.out.println(NEGRO + texto + RESET);
    }

    public static void rojo(String texto) {
        System.out.println(ROJO + texto + RESET);
    }

    public static void verde(String texto) {
        System.out.println(VERDE + texto + RESET);
    }
    
    public static void amarillo(String texto) {
        System.out.println(AMARILLO + texto + RESET);
    }

    public static void azul(String texto) {
        System.out.println(AZUL + texto + RESET);
    }

    public static void magenta(String texto) {
        System.out.println(MAGENTA + texto + RESET);
    }

    public static void cyan(String texto) {
        System.out.println(CYAN + texto + RESET);
    }

    public static void blanco(String texto) {
        System.out.println(BLANCO + texto + RESET);
    }
}