package com.hito2.proyecto.repository;


import com.hito2.proyecto.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
	 
	    List<Alumno> findByEmpresaId(Integer empresaId);
}
