package Examen_TerceraEvalucaion;

public abstract class Documentos {
	protected String nombre;
	protected String autor;
	protected String codigo;
	protected String anyo;
	protected String estado;
	protected String edicion;

	public Documentos(String nombre, String autor, String codigo, String anyo, String estado, String edicion) {
		this.nombre = nombre;
		this.autor = autor;
		this.codigo = codigo;
		this.anyo = anyo;
		this.estado = estado;
		this.edicion = edicion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the anyo
	 */
	public String getAnyo() {
		return anyo;
	}

	/**
	 * @param anyo the anyo to set
	 */
	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * @param edicion the edicion to set
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String generarId() {
		// Divido el nombre del autor en espacios
		String[] partes = autor.split(" ");
		String iniciales;

		// En caso de que este el nombre, apllido 1 y apllido 2
		if (partes.length >= 2) {
			iniciales = " " + partes[0].charAt(0) + partes[1].charAt(1) + partes[1].charAt(2);
			// En caso de que solo este el nombre
		} else {
			iniciales = partes[0].substring(0, 3);
		}
		// coge los últimos 4 del código
		String ultimos4 = codigo.substring(codigo.length() - 4);
		// Lo junta todo y lo pone en mayúsculas:
		return (iniciales + ultimos4 + "_" + anyo).toUpperCase();
	}

	public abstract String getTipo();

}
