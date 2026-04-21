package Ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String rutaIntroducida;

		while (true) {
			System.out.println(
					"\nIntroduce la ruta o pulsa Intro para salir:");
			rutaIntroducida = sc.nextLine();

			// El proceso se repetirá una y otra vez hasta que el usuario introduzca una ruta vacía (tecla intro).
			if (rutaIntroducida.isEmpty())
				break;

			try {
				File archivo = new File(rutaIntroducida);
				muestraInfoRuta(archivo);
				// Si el path no existe lanzará un FileNotFoundException.
			} catch (FileNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Ocurrió un error inesperado.");
			}
		}

		System.out.println("Programa finalizado.");
		sc.close();
	}

	public static void muestraInfoRuta(File ruta) throws FileNotFoundException {
		// Si esta vacia sale la excepción
		if (!ruta.exists()) {
			throw new FileNotFoundException("La ruta especificada no existe. Verifica que esté en Descargas.");
		}

		if (ruta.isFile()) {
			System.out.println(ruta.getName());
		}

		else if (ruta.isDirectory()) {
			File[] listado = ruta.listFiles();

			if (listado == null) {
				System.out.println("La carpeta está vacía.");
				return;
			}

			System.out.println("Contenido de: " + ruta.getName());

			// Mostrar directorios
			for (File f : listado) {
				if (f.isDirectory()) {
					System.out.println("[D] " + f.getName());
				}
			}

			// Mostrar archivos
			for (File f : listado) {
				if (f.isFile()) {
					System.out.println("[C] " + f.getName());
				}
			}
		}
	}
}