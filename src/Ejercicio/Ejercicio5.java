package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {

	public static void main(String[] args) {
		String ruta = "primos.txt";
		final int limite = 500;
		BufferedWriter bw = null;
		
		try {
			bw  = new BufferedWriter(new FileWriter(ruta));
			for (int i = 1; i < limite; i++) {
				if (esPrimo(i)) {
					bw.write(String.valueOf(i));
					bw.newLine();
				}
			}

			System.out.println("Ficheros primos.txt creado");

		} catch (IOException ioe) {
			System.out.println("Error: " + ioe.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch(IOException e) {
				System.out.println("Error");
			}
		}

	}

	public static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;

	}

}
