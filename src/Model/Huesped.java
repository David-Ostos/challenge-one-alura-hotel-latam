package Model;

import java.sql.Date;

public class Huesped {
	
	private Integer id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimineto;
	private String Nacionalidad;
	private String Telefono;
	private Integer idReserva;
	
	public Huesped(String nombre, String apellido, Date fechaNacimineto, String nacionalidad, String telefono,
			int idReserva) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimineto = fechaNacimineto;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		this.idReserva = idReserva;
	}
	
	
	public Huesped(int id, String nombre, String apellido, Date fechaNacimineto, String nacionalidad, String telefono,
			int idReserva) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimineto = fechaNacimineto;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		this.idReserva = idReserva;
	}


	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Date getFechaNacimineto() {
		return FechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		FechaNacimineto = fechaNacimineto;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	
}
