package com.hito2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hito2.proyecto.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}

