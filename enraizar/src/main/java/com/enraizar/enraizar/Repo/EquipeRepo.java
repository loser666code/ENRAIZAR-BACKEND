package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepo extends JpaRepository<Equipe,Integer> {

    Optional<Equipe> findById(Integer integer);
    Optional<Equipe> findByNome(String nome);
}
