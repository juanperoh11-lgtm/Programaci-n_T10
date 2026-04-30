package Examen_TerceraEvalucaion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Documentos> biblioteca = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int op = 0;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("biblioteca.txt"));
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] p = linea.split(":");

				try {

					if (p[2].length() == 13) {
						biblioteca.add(new Libro(p[0], p[1], p[2], p[3], p[4], p[5]));
					} else {
						biblioteca.add(new Revista(p[0], p[1], p[2], p[3], p[4], p[5]));
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Error al cargar línea: " + e.getMessage());
				}
			}
			System.out.println("Cargados " + biblioteca.size() + " documentos.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		do {
			System.out.println("MENU");
			System.out.println("1. Mostrar documentos ordenados por año");
			System.out.println("2. Buscar documento por ISBN/ISSN");
			System.out.println("3. Modificar estado de préstamo");
			System.out.println("4. Añadir un nuevo libro");
			System.out.println("5. Añadir una nueva revista");
			System.out.println("6. Guardar y salir");
			System.out.print("Seleccione una opción: ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				for (int i = 0; i < biblioteca.size() - 1; i++) {
					for (int j = i + 1; j < biblioteca.size(); j++) {
						if (biblioteca.get(i).getAnyo().compareTo(biblioteca.get(j).getAnyo()) < 0) {
							Collections.swap(biblioteca, i, j);
						}
					}
				}

				for (Documentos d : biblioteca) {
					System.out.println("[" + d.getTipo() + "] " + d.getNombre() + " | " + d.getAutor() + " | "
							+ d.getCodigo() + " | " + d.getAnyo() + " | " + d.getEstado() + " | ID: " + d.generarId()
							+ " | " + d.getEdicion());
				}
				break;

			case 2:
				System.out.print("Introduce el ISBN/ISSN: ");
				String cod = sc.nextLine();
				boolean encontrado = false;

				for (Documentos d : biblioteca) {
					if (d.getCodigo().equals(cod)) {
						System.out.println("Documento encontrado: " + d.getNombre() + " [" + d.getTipo() + "] Estado: "
								+ d.getEstado());
						encontrado = true;
						break;
					}
				}
				if (!encontrado)
					System.out.println("No se encontró ningún documento con ese código.");
				break;

			case 3:
				System.out.print("Introduce el ISBN/ISSN: ");
				String codMod = sc.nextLine().trim();

				for (Documentos d : biblioteca) {
					if (d.getCodigo().equals(codMod)) {

						if (d.getEstado().equals("El libro esta disponible")) {
							d.setEstado("PRESTADO");

						} else {
							System.out.println("Esta disponible");
						}

						System.out.println("Estado actualizado a: " + d.getEstado());
						break;
					}
				}
				break;

			case 4:
				System.out.println("Titulo: ");
				String titulo = sc.nextLine();
				System.out.println("Autor: ");
				String autor = sc.nextLine();
				System.out.println("ISBN: ");
				String codigo = sc.nextLine();
				System.out.println("Anyo: ");
				String anyo = sc.nextLine();
				System.out.println("Edicion: ");
				String edicion = sc.nextLine();

				try {

					biblioteca.add(new Libro(titulo, autor, codigo, anyo, edicion, "Disponible"));
					System.out.println("Revista añadida correctamente.");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 5:
				System.out.println("Titulo: ");
				String tituloR = sc.nextLine();
				System.out.println("Autor: ");
				String autorR = sc.nextLine();
				System.out.println("ISBN: ");
				String codigoR = sc.nextLine();
				System.out.println("Anyo: ");
				String anyoR = sc.nextLine();
				System.out.println("Edicion: ");
				String edicionR = sc.nextLine();

				try {
					biblioteca.add(new Revista(tituloR, autorR, codigoR, anyoR, edicionR, "Disponible"));
					System.out.println("Revista añadida correctamente.");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			}

		} while (op != 6);
		sc.close();

	}

}