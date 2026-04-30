package Examen_TerceraEvalucaion;

public class Revista extends Documentos {
	
	public Revista(String nombre, String autor, String codigo, String anyo, String estado, String edicion) {
		super(nombre, autor, codigo, anyo, estado, edicion);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Revista ";
	}
}
