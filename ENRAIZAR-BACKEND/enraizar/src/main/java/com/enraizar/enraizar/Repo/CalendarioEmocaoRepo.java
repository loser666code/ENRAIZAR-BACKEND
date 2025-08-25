package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.CalendarioEmocao;
import com.enraizar.enraizar.Model.CalendarioEmocao.CalendarioEmocaoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repositório JPA para Calendário-Emoções (chave composta)
public interface CalendarioEmocaoRepo extends JpaRepository<CalendarioEmocao, CalendarioEmocaoId> {
    // Lista vínculos por calendário
    List<CalendarioEmocao> findByIdCalendario(Integer idCalendario);

    // Obtém vínculo específico por (idCalendario, idEmocao)
    Optional<CalendarioEmocao> findByIdCalendarioAndIdEmocao(Integer idCalendario, Integer idEmocao);

    // Exclui vínculo específico por (idCalendario, idEmocao)
    void deleteByIdCalendarioAndIdEmocao(Integer idCalendario, Integer idEmocao);
}
