package Ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SolEjercicio12 {

	public static void main(String[] args) {
		BufferedReader br1 = null, br2 = null;
		BufferedWriter bw = null;

		try {
			br1 = new BufferedReader(new FileReader("alumnos_notas.txt"));
			br2 = new BufferedReader(new FileReader("usa_personas.txt"));
			bw = new BufferedWriter(new FileWriter("solucion12.txt"));

			String linea1 = br1.readLine();
			String linea2 = br2.readLine();

			// Mientras alguno de los dos tenga contenido...
			while (linea1 != null || linea2 != null) {

				if (linea1 != null) {
					bw.write(linea1 + "\n");
					linea1 = br1.readLine();
				}

				if (linea2 != null) {
					bw.write(linea2 + "\n");
					linea2 = br2.readLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br1 != null)
					br1.close();
				if (br2 != null)
					br2.close();
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
