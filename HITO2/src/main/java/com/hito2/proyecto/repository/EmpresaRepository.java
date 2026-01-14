package com.hito2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hito2.proyecto.model.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
