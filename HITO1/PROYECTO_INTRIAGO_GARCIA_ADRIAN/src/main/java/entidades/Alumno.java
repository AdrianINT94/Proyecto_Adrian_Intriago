package entidades;

public class Alumno extends Usuario{
	private String ciclo;
	private int curso;
	
	
	public Alumno(int id,String nombre,String email,String contrasena,String ciclo,int curso) {
		super(id,nombre,email,contrasena);
		this.ciclo=ciclo;
		this.curso=curso;
	}
	
	public String getCiclo() {return ciclo;}
	public void setCiclo(String ciclo) {this.ciclo=ciclo;}
	
	public int getCurso() {return curso;}
	public void setCurso(int curso) {this.curso=curso;}
	
	@Override
	public String toString () {
		return"Alumno: "+nombre+ "(" +ciclo+" -Curso "+curso+")";
	}

}
