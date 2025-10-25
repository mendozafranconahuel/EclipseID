package PARCIAL2023.PUNTO2;

import metodos.Colorear;

//usar en el caso de que pasillo tiene que ser una clase con metodo sincronizado

public class Pasillo {
    public synchronized void esperar(int id) {
    	Colorear.cyan("\t\t -- Aspirante "+id+": INGRESA al PASILLO.");
    }
}
