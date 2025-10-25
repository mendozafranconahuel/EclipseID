
package punto4;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Archivo {
	private static final Set<String> archivosDetectados = new HashSet<>();

	public static void verificarNuevosArchivos(String DIRECTORIO) {

		File carpeta = new File(DIRECTORIO);

		if (carpeta.exists() && carpeta.isDirectory()) {
			File[] archivos = carpeta.listFiles();

			if (archivos != null) {
				for (File archivo : archivos) {

					if (!archivosDetectados.contains(archivo.getName())) {
						archivosDetectados.add(archivo.getName());
						mostrarInformacionArchivo(archivo);
					}
				}
			}
		} else {
			System.out.println("La carpeta no existe");
		}
	}

	private static void mostrarInformacionArchivo(File archivo) {
		long tamanio = archivo.length();
		System.out.println("Nuevo archivo encontrado: " + archivo.getName() + " - Tamaño: " + tamanio + " bytes");
	}
}
