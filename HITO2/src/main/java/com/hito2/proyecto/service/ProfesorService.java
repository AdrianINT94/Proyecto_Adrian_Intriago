package com.hito2.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hito2.proyecto.model.Profesor;
import com.hito2.proyecto.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	private final ProfesorRepository repo;

    public ProfesorService(ProfesorRepository repo) {
        this.repo = repo;
    }

    public List<Profesor> findAll() {
        return repo.findAll();
    }

    public Profesor save(Profesor profesor) {
        return repo.save(profesor);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Profesor findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}

