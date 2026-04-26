package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el nombre del libro (ej: Quijote.txt): ");
		String ruta = sc.nextLine();

		int Nlineas = 0, Npalabras = 0, Ncaracteres = 0;
		HashMap<String, Integer> Palabras = new HashMap<>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea;

			while ((linea = br.readLine()) != null) {
				Nlineas++;
				Ncaracteres += linea.length();
				String[] palabras = linea.trim().split("\\s+");

				if (!linea.trim().isEmpty()) {
					Npalabras += palabras.length;

					for (String p : palabras) {
						// Limpiamos la palabra: a minúsculas y quitamos signos de puntuación
						String limpia = p.toLowerCase().replaceAll("[^a-záéíóúñ]", "");

						if (!limpia.isEmpty()) {
							Palabras.put(limpia, Palabras.getOrDefault(limpia, 0) + 1);
						}
					}
				}
			}
			mostrarResultados(Nlineas, Npalabras, Ncaracteres, Palabras);

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar.");
			}
			sc.close();
		}
	}

	public static void mostrarResultados(int l, int p, int c, HashMap<String, Integer> mapa) {
		System.out.println("\n--- ESTADÍSTICAS DEL LIBRO ---");
		System.out.println("Nº de líneas: " + l);
		System.out.println("Nº de palabras: " + p);
		System.out.println("Nº de caracteres: " + c);

		if (mapa.isEmpty()) {
			System.out.println("No se encontraron palabras.");
			return;
		}

		// 1. Encontrar la frecuencia máxima recorriendo los valores
		int maxFrecuencia = 0;
		for (String palabra : mapa.keySet()) {
			int frecuencia = mapa.get(palabra);
			if (frecuencia > maxFrecuencia) {
				maxFrecuencia = frecuencia;
			}
		}

		// 2. Mostrar todas las palabras que tengan esa frecuencia máxima
		System.out.println("Frecuencia máxima: " + maxFrecuencia);
		System.out.print("Palabra(s) más común(es): ");

		boolean primero = true;
		for (String palabra : mapa.keySet()) {
			if (mapa.get(palabra) == maxFrecuencia) {
				if (!primero)
					System.out.print(", ");
				System.out.print(palabra);
				primero = false;
			}
		}
		System.out.println(); // Salto de línea final
	}
}