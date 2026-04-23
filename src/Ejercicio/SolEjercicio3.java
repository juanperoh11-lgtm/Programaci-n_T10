package Ejercicio;

import java.io.File;

public class SolEjercicio3 {

	public static void main(String[] args) {

		File fDocAntigua = new File("Documentos");
		// Hay que poner DOCS porque File fFotoNueva = new File("DOCS\\FOTOS") no
		// encuentra File fFotoAntigua = new File("Documentos\\FOTOS");
		File fFotoAntigua = new File("DOCS\\Fotografias");
		File fLibrAntigua = new File("DOCS\\Libros");

		File fDocNueva = new File("DOCS");
		fDocAntigua.renameTo(fDocNueva);

		File fFotoNueva = new File("DOCS\\FOTOS");
		fFotoAntigua.renameTo(fFotoNueva);

		File fLibrNueva = new File("DOCS\\LECTURAS");
		fLibrAntigua.renameTo(fLibrNueva);

		// Tiene que ser fFotoNevo en lugar de fFotoAntigua porque se ha cambiado el
		// nombre y fFotoAntigua sique apuntando a la Antigua
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
