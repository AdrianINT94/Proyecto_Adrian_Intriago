package entidades;

import java.time.LocalDate;

public class FCT {
		private int id;
		private Alumno alumno;
		private Empresa empresa;
		private TutorEmpresa tutorEmpresa;
		private Profesor profesor;
		private LocalDate fechaInicio;
		private LocalDate fechaFin;
		
		
		
		public FCT(int id, Alumno alumno, Empresa empresa, TutorEmpresa tutorEmpresa, Profesor profesor,
				LocalDate fechaInicio, LocalDate fechaFin) {
			super();
			this.id = id;
			this.alumno = alumno;
			this.empresa = empresa;
			this.tutorEmpresa = tutorEmpresa;
			this.profesor = profesor;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Alumno getAlumno() {
			return alumno;
		}

		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}

		public Empresa getEmpresa() {
			return empresa;
		}

		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}

		public TutorEmpresa getTutorEmpresa() {
			return tutorEmpresa;
		}

		public void setTutorEmpresa(TutorEmpresa tutorEmpresa) {
			this.tutorEmpresa = tutorEmpresa;
		}

		public Profesor getProfesor() {
			return profesor;
		}

		public void setProfesor(Profesor profesor) {
			this.profesor = profesor;
		}

		public LocalDate getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(LocalDate fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public LocalDate getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(LocalDate fechaFin) {
			this.fechaFin = fechaFin;
		}
		
		@Override
		public String toString() {
			return"FCT de" +alumno.getNombre()+"en"+empresa.getNombre();
		}	
}
