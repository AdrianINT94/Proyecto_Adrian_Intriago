package com.hito3.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.hito3.proyecto.model.Alumno;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
	 
	    List<Alumno> findByEmpresaId(Integer empresaId);
}
