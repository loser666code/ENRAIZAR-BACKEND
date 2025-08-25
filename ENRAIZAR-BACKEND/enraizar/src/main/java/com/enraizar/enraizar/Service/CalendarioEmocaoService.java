package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.CalendarioEmocao;
import com.enraizar.enraizar.Repo.CalendarioEmocaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço de regras de negócio para Calendário-Emoções
@Service
public class CalendarioEmocaoService {

    // Repositório para acesso ao banco de Calendário-Emoções
    private final CalendarioEmocaoRepo repo;

    // Construtor com injeção de dependência do repositório
    @Autowired
    public CalendarioEmocaoService(CalendarioEmocaoRepo repo) {
        this.repo = repo;
    }

    // Lista todos os vínculos calendário-emoção
    public List<CalendarioEmocao> listarTodos() {
        return repo.findAll();
    }

    // Lista vínculos por id_calendario
    public List<CalendarioEmocao> listarPorCalendario(Integer idCalendario) {
        return repo.findByIdCalendario(idCalendario);
    }

    // Obtém um vínculo específico por (id_calendario, id_emocao)
    public Optional<CalendarioEmocao> obterVinculo(Integer idCalendario, Integer idEmocao) {
        return repo.findByIdCalendarioAndIdEmocao(idCalendario, idEmocao);
    }

    // Cadastra um novo vínculo com validações
    public void cadastrar(CalendarioEmocao ce) {
        validarObrigatorios(ce);
        normalizar(ce);
        repo.save(ce);
    }

    // Atualiza um vínculo existente com validações
    public void atualizar(CalendarioEmocao ce) {
        validarObrigatorios(ce);
        normalizar(ce);
        repo.save(ce);
    }

    // Exclui um vínculo específico por (id_calendario, id_emocao)
    public void deletar(Integer idCalendario, Integer idEmocao) {
        repo.deleteByIdCalendarioAndIdEmocao(idCalendario, idEmocao);
    }

    // Valida campos obrigatórios da entidade Calendário-Emoções
    private void validarObrigatorios(CalendarioEmocao ce) {
        if (ce == null) throw new RuntimeException("Vínculo não pode ser nulo");
        if (ce.getIdCalendario() == null) throw new RuntimeException("id_calendario é obrigatório");
        if (ce.getIdEmocao() == null) throw new RuntimeException("id_emocao é obrigatório");
    }

    // Normaliza campos de texto da entidade Calendário-Emoções
    private void normalizar(CalendarioEmocao ce) {
        if (ce.getObservacao() != null) {
            ce.setObservacao(ce.getObservacao().trim());
        }
    }
}
