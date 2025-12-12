package com.hito2.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hito2.proyecto.model.Profesor;
import com.hito2.proyecto.service.ProfesorService;


@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("lista", service.findAll());
        return "profesor-list";   // Vista FXML/HTML
    }

    @GetMapping("/form")
    public String form(Profesor profesor) {
        return "profesor-form";
    }

    @PostMapping("/save")
    public String save(Profesor profesor) {
        service.save(profesor);
        return "redirect:/profesor/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/profesor/list";
    }
}

