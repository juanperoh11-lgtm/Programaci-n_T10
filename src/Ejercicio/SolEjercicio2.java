package Ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolEjercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		File f = null;
		String ruta = "";

		do {
			try {
				System.out.println("Introduce una ruta");
				ruta = sc.nextLine();
				if (!ruta.equals("")) {
					f = new File(ruta);
					muestraInfo(f, true);
				}
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} while (!ruta.equals(""));
	}

	private static void muestraInfo(File fi, boolean inf) throws FileNotFoundException {
		if (!fi.exists())
			throw new FileNotFoundException("La ruta no existe");

		if (fi.isFile())
			System.out.println("[A] " + fi.getName());

		if (fi.isDirectory()) {
			File[] info = fi.listFiles();
			Arrays.sort(info);

			for (File fl : info) {

				if (fl.isDirectory()) {

					String infoAdicional = "";
					if (inf) {
						infoAdicional += "Tamaño en bytes: " + fl.length() + "" + fl.lastModified();
					}
					System.out.println("[*] " + fl + " " + infoAdicional);
				}
			}
			for (File fli : info) {
				if (fi.isFile()) {
					String infoAdicional = "";
					if (inf) {
						infoAdicional = " tamaño en bytes: " + fi.length() + " última modificación: "
								+ fi.lastModified();
					}
					System.out.println("[A] " + fli.getName() + infoAdicional);
				}
			}
		}
	}
}