package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.Emocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositório JPA para Emoção
public interface EmocaoRepo extends JpaRepository<Emocao, Integer> {
    // Busca por descrição
    Optional<Emocao> findByDescricao(String descricao);
}
