package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SolEjercicio15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BufferedWriter bw = null;
		int op;
		try {
			bw = new BufferedWriter(new FileWriter("productos.txt", true));
			do {
				System.out.println("1. Introduce un producto\n2. Salir");
				op = sc.nextInt();
				sc.nextLine();
				switch (op) {
				case 1:
					System.out.println("Introduce el nombre");
					String nombre = sc.nextLine().trim();
					System.out.println("Introduce la cantidad");
					String cant = sc.nextLine().trim();
					System.out.println("Introduce el precio");
					String pr = sc.nextLine().trim();
					bw.write(nombre + ":" + cant + ":" + pr + "\n");
					break;
				case 2:
					System.out.println("PROGRAMA TERMINADO");
					break;
				default:
					System.out.println("Opción no válida");

				}
			} while (op != 2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {

			}
		}

	}
}