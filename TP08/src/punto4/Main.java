
package punto4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	private static final String DIRECTORIO = "C:\\Users\\elabo\\Desktop\\Nueva carpeta";

	public static void main(String[] args) {

		ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();

		scheduled.scheduleWithFixedDelay(() -> {
			Archivo.verificarNuevosArchivos(DIRECTORIO);
		}, 0, 5, TimeUnit.SECONDS);
	}

}
