package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.EquipeUsuarios;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EquipeUsuarioRepo extends JpaRepository<EquipeUsuarios, Integer> {
    Optional<EquipeUsuarios> findById(Integer id);
}
