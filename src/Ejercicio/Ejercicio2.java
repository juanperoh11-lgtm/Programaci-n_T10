package Ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String rutaIntroducida;

		while (true) {
			System.out.println("\nIntroduce la ruta o pulsa Intro para salir:");
			rutaIntroducida = sc.nextLine();

			if (rutaIntroducida.isEmpty())
				break;

			try {
				File archivo = new File(rutaIntroducida);
				muestraInfoRuta(archivo, true);
			} catch (FileNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Ocurrió un error inesperado.");
			}
		}

		System.out.println("Programa finalizado.");
		sc.close();
	}

	public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException {
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

			Arrays.sort(listado);
			System.out.println("Contenido de: " + ruta.getName());

			for (File f : listado) {
				if (f.isDirectory()) {
					imprimirConDetalle(f, info);
				}
			}

			for (File f : listado) {
				if (f.isFile()) {
					imprimirConDetalle(f, info);
				}
			}
		}
	}

	public static void imprimirConDetalle(File f, boolean info) {
		String etiqueta;
		if (f.isDirectory())
			etiqueta = "[D]";
		else
			etiqueta = "[A]";
		String resultado = etiqueta + " " + f.getName();
		if (info) {
			long tamaño = f.length();
			Date fecha = new Date(f.lastModified());
			resultado += String.format(" - %d bytes - Modificado: %s", tamaño, fecha);
		}

		System.out.println(resultado);
	}
}