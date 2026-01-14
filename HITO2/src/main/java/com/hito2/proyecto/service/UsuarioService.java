package com.hito2.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hito2.proyecto.model.Usuario;
import com.hito2.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	 private final UsuarioRepository repo;

	    public UsuarioService(UsuarioRepository repo) {
	        this.repo = repo;
	    }

	    public List<Usuario> findAll() {
	        return repo.findAll();
	    }

	    public Usuario save(Usuario usuario) {
	        return repo.save(usuario);
	    }

	    public void delete(Long id) {
	        repo.deleteById(id);
	    }

	    public Usuario findById(Long id) {
	        return repo.findById(id).orElse(null);
	    }
	}

