package entidades;

public class TutorEmpresa extends Usuario{
	private Empresa empresa;

	public TutorEmpresa(int id, String nombre, String email, String contrasena, Empresa empresa) {
		super(id, nombre, email, contrasena);
		this.empresa = empresa;
	
	}
	public Empresa getEmpresa() {return empresa;}
	public void setEmpresa(Empresa empresa) {this.empresa=empresa;}
	
	@Override
	public String toString() {
		return "Tutor Empresa:"+nombre+"("+empresa.getNombre()+")";
	}
	
	

}
