package com.hito2.proyecto.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hito2.proyecto.model.FCT;
import com.hito2.proyecto.repository.FctRepository;

public class FctService {
	
	private final FctRepository repo;

    public FctService(FctRepository repo) {
        this.repo = repo;
    }

    public List<FCT> findAll() {
        return repo.findAll();
    }

    public FCT save(FCT fct) {
        return repo.save(fct);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public FCT findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}

