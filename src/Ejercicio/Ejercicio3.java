package Ejercicio;

import java.io.File;

public class Ejercicio3 {

	public static void main(String[] args) {

		String rutaBase = "C:\\Users\\aleja\\Downloads\\";

		renombrar(rutaBase + "Documentos", rutaBase + "DOCS");
		renombrar(rutaBase + "Fotografias", rutaBase + "FOTOS");
		renombrar(rutaBase + "Libros", rutaBase + "LECTURAS");

		quitarExtensiones(new File(rutaBase + "FOTOS"));
		quitarExtensiones(new File(rutaBase + "LECTURAS"));

		System.out.println("Proceso finalizado.");
	}

	private static void quitarExtensiones(File directorio) {
		if (directorio.exists() && directorio.isDirectory()) {
			File[] ficheros = directorio.listFiles();

			if (ficheros != null) {
				for (File f : ficheros) {
					String nombreOriginal = f.getName();
					int indicePunto = nombreOriginal.lastIndexOf('.');

					if (indicePunto > 0) {
						String nuevoNombreStr = nombreOriginal.substring(0, indicePunto);

						File nuevoFichero = new File(f.getParent(), nuevoNombreStr);

						if (f.renameTo(nuevoFichero)) {
							System.out.println("Extensión eliminada: " + nombreOriginal + " -> " + nuevoNombreStr);
						}
					}
				}
			}
		}

	}

	private static void renombrar(String antiguaRuta, String nuevaRuta) {
		File antiguo = new File(antiguaRuta);
		File nuevo = new File(nuevaRuta);

		if (antiguo.exists()) {
			if (antiguo.renameTo(nuevo)) {
				System.out.println("Renombrado con éxito: " + antiguo.getName() + " -> " + nuevo.getName());
			} else {
				System.out.println("Error al intentar renombrar: " + antiguo.getName());
			}
		} else {
			System.out.println("No se encontró la ruta: " + antiguaRuta);
		}

	}

}
