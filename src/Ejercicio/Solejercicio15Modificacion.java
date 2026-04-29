package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solejercicio15Modificacion {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> listaProductos = new ArrayList<>();
		BufferedWriter bw = null;
		int op;

		try {

			bw = new BufferedWriter(new FileWriter("productos.txt", true));
			do {
				System.out.println("MENU");
				System.out.println("1. Añadir");
				System.out.println("2. Mostrar todos ordenados");
				System.out.println("3. Guardar");
				System.out.println("4. Salir");

				op = sc.nextInt();
				switch (op) {
				case 1:
					System.out.println("Introduce el nombre del producto a añadir");
					String nombre = sc.nextLine();
					System.out.println("Introduce la cantidad:");
					String cant = sc.nextLine().trim();
					System.out.println("Introduce el precio:");
					String pr = sc.nextLine().trim();

					listaProductos.add(nombre + ":" + cant + ":" + pr);
					System.out.println("Producto añadido a la lista.");
					break;

				case 2:
					if (listaProductos.isEmpty()) {
						System.out.println("No hay productos");
					} else {
						Collections.sort(listaProductos);
						System.out.println("Productos ordenados:");
						for (String p : listaProductos) {
							System.out.println(p);
						}
					}
					break;

				case 3:
					for (String p : listaProductos) {
						bw.write(p + "\n");
					}
					System.out.println("Datos guardados en el fichero correctamente.");
					break;

				case 4:
					System.out.println("PROGRAMA TERMINADO");
					break;
				}
			} while (op != 4);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}