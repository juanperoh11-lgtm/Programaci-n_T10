package Clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lecturas_Escrituras {

	public static void main(String[] args) {

		// --- BLOQUE DE LECTURA ---
		FileReader f = null;
		BufferedReader br = null;
		try {
			f = new FileReader("fich.txt");
			br = new BufferedReader(f);

			String lectura;
			while ((lectura = br.readLine()) != null) {
				System.out.println(lectura);
			}

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (f != null)
					f.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// --- BLOQUE DE ESCRITURA (Ahora dentro del main) ---
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("fich.txt", true);
			bw = new BufferedWriter(fw);

			bw.write("\n");
			for (int i = 0; i < 10; i++) {
				bw.write(i + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	} 
} 