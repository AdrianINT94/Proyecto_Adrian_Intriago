package com.hito2.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	 @Autowired
	    private AlumnoService alumnoService;

	    // Obtener todos los alumnos (HTTP GET)
	    @GetMapping
	    public List<Alumno> getAllAlumnos() {
	        return alumnoService.findAll();
	    }

	    // Obtener un alumno por ID (HTTP GET)
	    @GetMapping("/{id}")
	    public Alumno getAlumnoById(@PathVariable Long id) {
	        return alumnoService.findById(id);
	    }

	    // Crear un nuevo alumno (HTTP POST)
	    @PostMapping
	    public Alumno createAlumno(@RequestBody Alumno alumno) {
	        return alumnoService.save(alumno);
	    }

	    // Actualizar un alumno (HTTP PUT)
	    @PutMapping("/{id}")
	    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
	        Alumno alumno = alumnoService.findById(id);
	        alumno.setNombre(alumnoDetails.getNombre());
	        alumno.setEmail(alumnoDetails.getEmail());
	        alumno.setCiclo(alumnoDetails.getCiclo());
	        alumno.setCurso(alumnoDetails.getCurso());
	        return alumnoService.save(alumno);
	    }

	    // Eliminar un alumno (HTTP DELETE)
	    @DeleteMapping("/{id}")
	    public void deleteAlumno(@PathVariable Long id) {
	    	 alumnoService.delete(id);
	    }

	    
	    

	    // Obtener alumnos por el ID de la empresa (HTTP GET)
	    @GetMapping("/empresa/{empresaId}")
	    public List<Alumno> getAlumnosByEmpresa(@PathVariable Long empresaId) {
	        return alumnoService.findByEmpresaId(empresaId);
	    }
	}

