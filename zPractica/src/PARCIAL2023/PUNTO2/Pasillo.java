package PARCIAL2023.PUNTO2;

import metodos.Colorear;

public class Pasillo {
    public synchronized void esperar(int id) {
    	Colorear.cyan("\t\t -- Aspirante "+id+": INGRESA al PASILLO.");
    }
}
