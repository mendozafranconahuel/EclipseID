package punto3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tarea {
	//private String url;
	private String [] noticias;
	private int id;
	
    public Tarea(String  noticias[] , int id) {
       this.noticias =noticias;
       this.id=id;
    	
    }
    	
	
    // leer el contenido de la noticia
    private static String leerContenido(String url) throws Exception {
        @SuppressWarnings("deprecation")
		URL URL = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) URL.openConnection();
        conexion.setRequestMethod("GET");

        // Leer la respuesta de la conexion
        BufferedReader respuesta = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = respuesta.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
        respuesta.close();

        return contenido.toString();
    }
    private static String extraerContenidoDiv(String html) {
        String div = "<div[^>]*class=\"articulo__cuerpo\"[^>]*>(.*?)</div>";
        Pattern pattern = Pattern.compile(div, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "No se encontró el contenido del div";
    }
    
    private static String extraerTexto(String html) {
    	 
    	String texto = "<p>(.*?)</p>";
        Pattern pattern = Pattern.compile(texto, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        StringBuilder resultado = new StringBuilder();
        while (matcher.find()) {
            resultado.append(matcher.group(1).trim()).append("\n");
        }
        return resultado.length() > 0 ? resultado.toString() : "No se encontró el contenido en los párrafos.";
    }
   
    public void mostrar() {
        try {
            if (id >= 0 && id < noticias.length) {
                long tiempoInicial = System.currentTimeMillis();
                String url = noticias[id];
                String contenido = leerContenido(url);

                String contenidoDiv = extraerContenidoDiv(contenido);
                String parrafos = extraerTexto(contenidoDiv);

                System.out.println("\n" + "Contenido de los párrafos en la noticia " + (id + 1) + ":\n" + parrafos);

                long tiempoFinal = System.currentTimeMillis();
                System.out.println("Tiempo de ejecución para obtener la noticia " + (id + 1) + ": " + (tiempoFinal - tiempoInicial) + " ms");
            } else {
                System.out.println("Posición inválida");
            }
        } catch (Exception e) {
            System.out.println("Error al leer la noticia: " + e.getMessage());
        }
    }
}
		 