package Model;

public class Usuarios {

	private Integer id;
	private String Usuario;
	private String Password;
	
		public Usuarios(String usuario, String password) {
		super();
		Usuario = usuario;
		Password = password;
	}
		
	public String getPassword() {
		return Password;
	}

	public String getUsuario() {
		return Usuario;
	}

	public Integer getId() {
		return id;
	}
	


	
}
