package com.hito2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hito2.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
