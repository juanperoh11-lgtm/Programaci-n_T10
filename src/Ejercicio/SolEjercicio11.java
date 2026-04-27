package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SolEjercicio11 {

	public static void main(String[] args) {

		int mayor = Integer.MAX_VALUE;
		int menor = Integer.MIN_VALUE;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Texto.txt"));
			String linea = "";

			while ((linea = br.readLine()) != null) {
				try {
					int num = Integer.parseInt(linea);
					if (num > mayor)
						mayor = num;
					if (num < menor)
						menor = num;

				} catch (NumberFormatException e) {
					System.out.println("Problema " + e.getMessage());

				}
			}
		} catch (IOException e) {

		}
	}

}
