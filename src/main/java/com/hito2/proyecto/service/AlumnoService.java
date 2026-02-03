package com.hito2.proyecto.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.repository.AlumnoRepository;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Integer id) {
        alumnoRepository.deleteById(id);
    }

    public List<Alumno> findByEmpresaId(Integer empresaId) {
        return alumnoRepository.findByEmpresaId(empresaId);
    }
}