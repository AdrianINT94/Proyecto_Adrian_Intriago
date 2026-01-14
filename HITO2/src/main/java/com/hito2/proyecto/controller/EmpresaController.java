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
import com.hito2.proyecto.model.Empresa;
import com.hito2.proyecto.service.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresaById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaDetails) {
        Empresa empresa = empresaService.findById(id);
        if (empresa != null) {
            empresa.setNombre(empresaDetails.getNombre());
            empresa.setDireccion(empresaDetails.getDireccion());
            return empresaService.save(empresa);
        } else {
            return null; // o lanzar una excepción si prefieres
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable Long id) {
        empresaService.delete(id);
    }
}
