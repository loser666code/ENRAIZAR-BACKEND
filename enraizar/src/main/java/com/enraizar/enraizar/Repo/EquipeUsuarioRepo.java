package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.EquipeUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EquipeUsuarioRepo extends JpaRepository<EquipeUsuarios, Integer> {

    List<EquipeUsuarios> findByEquipeId(Integer id_equipe);
}
