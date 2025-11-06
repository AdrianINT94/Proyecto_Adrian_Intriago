package entidades;

public class Usuario {
		protected int id;
		protected String nombre;
		protected String email;
		protected String contraseña;
		
		public Usuario(int id,String nombre, String email,String contrasena) {
			this.id=id;
			this.nombre=nombre;
			this.email=email;
			this.contraseña=contrasena;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContraseña() {
			return contraseña;
		}

		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		
		@Override
		public String toString() {
			return nombre +"("+email+")";				
			}
		}

