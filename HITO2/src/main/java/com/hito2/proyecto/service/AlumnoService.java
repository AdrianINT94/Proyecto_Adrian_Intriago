package com.hito2.proyecto.service;

import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    
   

    public List<Alumno> findByEmpresaId(Long empresaId) {
        return alumnoRepository.findByEmpresaId(empresaId);
    }
}

