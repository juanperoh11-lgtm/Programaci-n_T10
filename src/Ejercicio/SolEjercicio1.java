package Ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SolEjercicio1 {

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
					muestraInfo(f);
				}
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		} while (!ruta.equals(""));
	}

	private static void muestraInfo(File fi) throws FileNotFoundException {
		if (!fi.exists())
			throw new FileNotFoundException("La ruta no existe");
		if (fi.isFile())
			System.out.println("[A]" + fi.getName());
		// Para mirar dentro de las carpetas
		if (fi.isDirectory()) {
			File info[] = fi.listFiles();
			for (File fl : info) {
				if (fl.isDirectory())
					System.out.println("[*]" + fl.getName());
				else if (fl.isFile())
					System.out.println("[A]" + fl.getName());
			}

			for (File fli : info) {
				if (fli.isFile())
					System.out.println("[A]" + fli.getName());
			}

		}

	}

}
