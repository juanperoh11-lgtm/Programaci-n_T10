package Ejercicio;

import java.io.File;

public class SolEjercicio3 {

	public static void main(String[] args) {

		File fDocAntigua = new File("Documentos");
		File fFotoAntigua = new File("Documentos\\Fotografias");
		File fLibrAntigua = new File("Documentos\\Libros");

		File fDocNueva = new File("DOCS");
		fDocAntigua.renameTo(fDocNueva);

		File fFotoNueva = new File("DOCS\\FOTOS");
		fFotoAntigua.renameTo(fFotoNueva);

		File fLibrNueva = new File("DOCS\\LECTURAS");
		fLibrAntigua.renameTo(fLibrNueva);

		quitarExtension(fFotoAntigua);

	}

	private static void quitarExtension(File f) {
		if (f.isDirectory()) {
			File files[] = f.listFiles();
			for (File fi : files) {
				if (fi.isFile()) {
					// Hay que quitar la extension si es un file
					String n = fi.getName();
					n = n.substring(0, n.indexOf("."));
					fi.renameTo(new File(f.getAbsolutePath() + "\\" + n));
				}
			}
		}
	}

}
