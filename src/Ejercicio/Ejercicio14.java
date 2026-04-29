package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio14 {

	public static void main(String[] args) {
		String ruta = "productos.txt";
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(ruta));
			String nombre;
			int contL =1;

			while ((nombre = br.readLine()) != null) {
				try {
					String lineaCantidad = br.readLine();
					String lineaPrecio = br.readLine();

					if (lineaCantidad == null || lineaPrecio == null) {
						throw new Exception("Datos incompletos del producto: " + nombre);
					}

					int cantidad = Integer.parseInt(lineaCantidad.trim());
					double precio = Double.parseDouble(lineaPrecio.trim());

					Producto p = new Producto(nombre, cantidad, precio);
					System.out.println(p.toString());

				} catch (Exception e) {
					System.out.println("Hublo un eror en la linea " + contL + " : "+   e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
	}

}
