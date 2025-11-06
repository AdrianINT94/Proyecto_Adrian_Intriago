package entidades;

public class Profesor extends Usuario{
	private String ciclo;
	private int curso;
	
	public Profesor(int id,String nombre,String email,String contrasena,String ciclo,int curso) {
		super(id,nombre,email,contrasena);
		this.ciclo=ciclo;
		this.curso=curso;
	}
	public String getCiclo() {return ciclo;}
	public void setCiclo(String ciclo) {this.ciclo=ciclo;}
	
	public int getCurso() {return curso;}
	public void setCurso(int curso) {this.curso=curso;}
	
	@Override
	public String toString() {
		return"Profesor:" +nombre+"("+ciclo+"-Curso" +curso+")";
	}

}
