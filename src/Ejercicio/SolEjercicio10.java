package Ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SolEjercicio10 {

	public static void main(String[] args) throws IOException {

		analizarArchivo("Documentos\\Libros\\quijote_cervantes.txt");

	}

	private static void analizarArchivo(String ruta) {

		FileReader f = null;
		BufferedReader br = null;

		int nLineas = 0, nPalabras = 0, nCaracteres = 0;
		HashMap<String, Integer> mapa = new HashMap<>();

		try {
			f = new FileReader(ruta);
			br = new BufferedReader(f);

			String linea;
			while ((linea = br.readLine()) != null) {
				nLineas++;
				nCaracteres += linea.length();

				String palabras[] = linea.split("\\s+");
				for (String p : palabras) {
					if (!p.isEmpty()) {
						nPalabras++;
						p = p.toLowerCase();
						// Guardamos en el mapa
						if (mapa.containsKey(p)) {
							// Sacamos las repeticiones de la palabra si ya está
							int veces = mapa.get(p);
							// La volvemos a guardar pero sumándole 1
							mapa.put(p, veces + 1);
						} else {
							// Si es la primera vez que sale, la guardamos con un 1
							mapa.put(p, 1);
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado: " + ruta);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (f != null)
					f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
