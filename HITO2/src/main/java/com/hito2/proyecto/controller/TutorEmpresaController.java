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

import com.hito2.proyecto.model.TutorEmpresa;
import com.hito2.proyecto.service.TutorEmpresaService;

@RestController
@RequestMapping("/api/tutores-empresa")
public class TutorEmpresaController {
	
	@Autowired
    private TutorEmpresaService tutorEmpresaService;

    @GetMapping
    public List<TutorEmpresa> getAllTutoresEmpresa() {
        return tutorEmpresaService.findAll();
    }

    @GetMapping("/{id}")
    public TutorEmpresa getTutorEmpresaById(@PathVariable Long id) {
        return tutorEmpresaService.findById(id);
    }

    @PostMapping
    public TutorEmpresa createTutorEmpresa(@RequestBody TutorEmpresa tutorEmpresa) {
        return tutorEmpresaService.save(tutorEmpresa);
    }

    @PutMapping("/{id}")
    public TutorEmpresa updateTutorEmpresa(@PathVariable Long id, @RequestBody TutorEmpresa tutorEmpresaDetails) {
        TutorEmpresa tutorEmpresa = tutorEmpresaService.findById(id);
        tutorEmpresa.setNombre(tutorEmpresaDetails.getNombre());
        tutorEmpresa.setEmail(tutorEmpresaDetails.getEmail());
        return tutorEmpresaService.save(tutorEmpresa);
    }

    @DeleteMapping("/{id}")
    public void deleteTutorEmpresa(@PathVariable Long id) {
        tutorEmpresaService.delete(id);
    }
}

