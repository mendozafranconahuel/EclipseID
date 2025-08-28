package metodos;
import java.util.Scanner;
import java.math.BigDecimal;//funciones
import java.math.RoundingMode;

public class Metodo {
	static Scanner s = new Scanner(System.in);
//-------------------------------------------------------------------------------------------
	public static int pedirEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = s.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print(" - ERROR: Ingrese un número entero válido.");
            }
        }
    }
//-------------------------------------------------------------------------------------------

    public static long pedirLong(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = s.nextLine();
                return Long.parseLong(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" - ERROR: Ingrese un número entero largo válido.");
            }
        }
    }
//-------------------------------------------------------------------------------------------

    public static double pedirDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = s.nextLine();
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" - ERROR: Ingrese un número con decimales válido.");
            }
        }
    }
  //-------------------------------------------------------------------------------------------

    public static double pedirDoublePositivo(String mensaje) {
    double numero;
    	while (true) {
            numero = pedirDouble(mensaje);
            try {
                if (numero>0.01) {
                	   return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println(" - ERROR: Ingrese un número con decimales válido.");
            }
        }
   }
//----------------------------------------------------------------------------------------------------
    public static float pedirFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = s.nextLine();
                return Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" - ERROR: Ingrese un número con decimales válido.");
            }
        }
    }
//----------------------------------------------------------------------------------------------------
public static String cadena(String mensaje) {
        System.out.print(mensaje);
        return s.nextLine();
}
//----------------------------------------------------------------------------------------------------


///////////////////////////////////////////////////////////////////////////////////////////////////	

public static String respuesta(String opcion, String mensaje) {
	while (true) {
		System.out.print(mensaje);
		opcion = s.nextLine();
		if (opcion.equalsIgnoreCase("s")||opcion.equalsIgnoreCase("SI")||
			opcion.equalsIgnoreCase("n")||opcion.equalsIgnoreCase("NO")){
			return opcion;
		}
		else {
			System.out.println("\n\n  ¡ERROR!: UNA DE LAS OPCIONES DADAS [SI/S - NO/N] ");
		}
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////	

public static double redondear(double valor, int dicimales) {
	BigDecimal numero = new BigDecimal(valor);
	numero = numero.setScale(dicimales, RoundingMode.HALF_UP);
return numero.doubleValue();
}
///////////////////////////////////////////////////////////////////////////////////////////////////

public static int validarLong(long numero) {
	long numeroAbsoluto = Math.abs(numero);
	String texto = String.valueOf(numeroAbsoluto);
return texto.length();
}
///////////////////////////////////////////////////////////////////////////////////////////////////	

public static double dimencion(String mensaje , double mayor) {
    double numero;
    while (true) {
        numero = pedirDouble(mensaje);
        if (numero > mayor) {
        	return numero;
        }
        else {
        	System.out.println("INGRESE UN NUMERO MAYOR A"+mayor+"\n");
        }
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////	

public static int validarOpcion(int limite) {
    int numero;
	while (true) {
        numero = pedirEntero("\t >OPCION: ");
            if (numero >= 1 && numero <= limite) {
            	return numero;
            }
            else {
            System.out.println(" -->  OPCION NO VALIDA");
            }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////	

}//end metodo