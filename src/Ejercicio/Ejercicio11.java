package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio11 {

	public static void main(String[] args) {
		String ruta = "numeros.txt";
		BufferedReader br = null;

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		boolean encontrado = false;

		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea;

			while ((linea = br.readLine()) != null) {
				String dato = linea.trim();

				if (!dato.isEmpty()) {
					try {
						int numeros = Integer.parseInt(dato);

						encontrado = true;

						if (numeros > max)
							max = numeros;

						if (numeros < min)
							min = numeros;

					} catch (NumberFormatException e) {
						System.out.println("Dato errónes: " + dato);
					}
				}
			}
			imprimirResultados(max, min, encontrado);
		} catch (IOException ioe) {
			System.out.println("Error: " + ioe.getMessage());

		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				System.out.println("Error: " + ioe.getMessage());
			}
		}
	}

	public static void imprimirResultados(int max, int min, boolean hayDatos) {
		if (hayDatos) {
			System.out.println("Maximo: " + max);
			System.out.println("Mínimo: " + min);
		} else {
			System.out.println("No hay números válidos");
		}
	}

}
