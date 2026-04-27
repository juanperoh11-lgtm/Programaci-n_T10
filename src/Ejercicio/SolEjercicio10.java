package Ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class SolEjercicio10 {

	public static void main(String[] args) {
		String ruta = "Texto.txt";
		int numLineas = 0, numPalabras = 0, numLetras = 0;
		Map<String, Integer> Frecuencia = new HashMap<String, Integer>();

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea = "";

			while ((linea = br.readLine()) != null) {
				numLineas++;
				String[] palabras = linea.split(" ");
				llenarHasMapFrecuencia(palabras, Frecuencia);

				// Hacer en casa
				// limpiarPalabras();
				numPalabras += palabras.length;

				String lineaSinEspacios = linea.replace(" ", "");
				numLetras += lineaSinEspacios.length();

				// Mostramos la palabra mas fecuente en el texto
				int mayor = Integer.MIN_VALUE;
				String claveMayor = "";
				List<Integer> alNumFec = new ArrayList<Integer>(Frecuencia.values());
				Collections.sort(alNumFec);

				for (Entry<String, Integer> par : Frecuencia.entrySet()) {
					if (par.getValue() == alNumFec.get(alNumFec.size() - 1)) {
						System.out.println("La palabra: \"" + par.getKey() + "\" es la más frecuente con "
								+ par.getValue() + " apariciones.");
						claveMayor = par.getKey();
						mayor = par.getValue();
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public static void llenarHasMapFrecuencia(String[] palabras, Map<String, Integer> frecuencia) {
		for (String pal : palabras) {
			if (!pal.isEmpty())
				frecuencia.put(pal, frecuencia.getOrDefault(pal, 0) + 1);
		}
	}
}