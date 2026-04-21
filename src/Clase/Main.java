package Clase;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		 
		// La clas file se usa para señalizar ficheros. En ortras palabras es un apuntador a una dirección
		File f = new File("C:\\Users\\aleja\\Downloads");
		//Ver metodos f.
		/// getName nombre carpeto o fichero
		System.out.println(f.getName());
		/// Exist es booleano y te dice si una carperta o fichero exsiste dentro de tu ordenador
		System.out.println(f.exists());

		
		//Dentro de arrays
		
		System.out.println("-----------------------------------------");
		
		///Este te devuelve en strings
		//En este caso este no se usa porque tengdrias que hacer un get file del array porque guar nombres, no apuntadores
		//String [] nombresF =f.list();
		
		///Este te devuelve los apuntadores de las clases
		File [] f2 =  f.listFiles();
		for(File fl:f2)
			System.out.println(fl.getName());
		
		
		System.out.println("------------------------------------------------");
		
		//Existen dos tipos de rutas, una obsoluta aque es la aque hemos estando usando y las relativas que es donde java esta ejecuntado
		//las punto class
		File f1 = new File("C:\\Users\\aleja\\Downloads\\Regalo maria\\Primer Regalo");
		System.out.println(f1.exists());
		///Si exsite algún fichero dentro
		System.out.println(f1.isFile());
		///Devolve la carpeta padre
		System.out.println(f1.getParent());
		
		
		System.out.println("---------------------------------------------------------");
		//Ejercicio1 Crear un programa que recorra la carpeta descargas y que mire que son ficheros y que son carpetas
		File f4 = new File("Documentos");
		File [] ficheros = f4.listFiles();
		int dir =0;
		int fi =0;
		for(File fl:ficheros) {
			if(fl.isDirectory())
				dir ++;
			else
				fi ++;
		}
		System.out.println(dir);
		System.out.println(fi);
	}

}
