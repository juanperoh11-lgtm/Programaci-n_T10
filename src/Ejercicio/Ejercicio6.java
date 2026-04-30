package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		String ruta = "primos.txt";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(ruta));
			String linea ="";
			System.out.println("Leyendo los números primos");
			
			while((linea = br.readLine()) !=null) {
				System.out.println(linea);
			}
		}catch(IOException ioe) {
			System.out.println("Error: " + ioe.getLocalizedMessage());
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
			}
		}
		
	}

}
