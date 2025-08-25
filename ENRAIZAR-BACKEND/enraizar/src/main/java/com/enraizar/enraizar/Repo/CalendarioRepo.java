package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositório JPA para Calendário
public interface CalendarioRepo extends JpaRepository<Calendario, Integer> {
    // Lista registros pelo id do usuário
    List<Calendario> findByIdUsuario(Integer idUsuario);
}
