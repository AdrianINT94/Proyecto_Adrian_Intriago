package com.hito2.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public Alumno getAlumnoById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno updateAlumno(@PathVariable Integer id, @RequestBody Alumno alumnoDetails) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) return null;

        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setEmail(alumnoDetails.getEmail());
        alumno.setCiclo(alumnoDetails.getCiclo());
        alumno.setCurso(alumnoDetails.getCurso());

        return alumnoService.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Integer id) {
        alumnoService.delete(id);
    }

    @GetMapping("/empresa/{empresaId}")
    public List<Alumno> getAlumnosByEmpresa(@PathVariable Integer empresaId) {
        return alumnoService.findByEmpresaId(empresaId);
    }
}