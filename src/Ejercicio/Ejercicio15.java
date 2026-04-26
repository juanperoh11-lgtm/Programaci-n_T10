package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {

		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		String ruta = "Productos.txt";

		try {
			bw = new BufferedWriter(new FileWriter(ruta));
			System.out.println("Introduce el nombre del producto");
			String nombre = sc.nextLine();

			System.out.println("Introduce una cantidad");
			int cantidad = sc.nextInt();

			System.out.println("Introduce el precio");
			double precio = Double.parseDouble(sc.nextLine());

			bw.write(nombre);
			bw.newLine();

			bw.write(String.valueOf(cantidad));
			bw.newLine();

			bw.write(String.valueOf(precio));
			bw.newLine();

			System.out.println("Producto guardado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			sc.close();
		}
	}

}
