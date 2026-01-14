package com.hito2.proyecto.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.hito2.proyecto.model.Profesor;
import com.hito2.proyecto.repository.ProfesorRepository;
import java.util.Optional;
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

    public void delete(Integer id) {  
        repo.deleteById(id);
    }

    public Profesor findById(Integer id) {  
        return repo.findById(id).orElse(null);
    }
}
