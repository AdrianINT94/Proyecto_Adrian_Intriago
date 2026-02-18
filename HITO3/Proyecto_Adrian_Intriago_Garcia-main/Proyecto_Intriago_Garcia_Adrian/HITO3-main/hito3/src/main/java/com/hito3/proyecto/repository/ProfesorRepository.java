package com.hito3.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hito3.proyecto.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}

