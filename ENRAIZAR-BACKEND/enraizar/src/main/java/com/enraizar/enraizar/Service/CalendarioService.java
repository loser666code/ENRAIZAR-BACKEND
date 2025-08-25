package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Calendario;
import com.enraizar.enraizar.Repo.CalendarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço de regras de negócio para Calendário
@Service
public class CalendarioService {

    // Repositório para acesso ao banco de dados de Calendário
    private final CalendarioRepo repo;

    // Construtor com injeção de dependência do repositório
    @Autowired
    public CalendarioService(CalendarioRepo repo) {
        this.repo = repo;
    }

    // Lista todos os registros de calendário
    public List<Calendario> listarCalendarios() {
        return repo.findAll();
    }

    // Obtém um registro de calendário pelo ID
    public Optional<Calendario> obterCalendarioPorId(Integer id) {
        return repo.findById(id);
    }

    // Lista registros por usuário
    public List<Calendario> listarPorUsuario(Integer idUsuario) {
        return repo.findByIdUsuario(idUsuario);
    }

    // Cadastra um novo registro com validações
    public void cadastrarCalendario(Calendario c) {
        validarObrigatorios(c);
        normalizar(c);
        repo.save(c);
    }

    // Atualiza um registro existente com validações
    public void atualizarCalendario(Calendario c) {
        validarObrigatorios(c);
        normalizar(c);
        repo.save(c);
    }

    // Exclui um registro de calendário pelo ID
    public void deletarCalendario(Integer id) {
        repo.deleteById(id);
    }

    // Valida campos obrigatórios da entidade Calendário
    private void validarObrigatorios(Calendario c) {
        if (c == null) throw new RuntimeException("Calendário não pode ser nulo");
        if (c.getIdUsuario() == null) throw new RuntimeException("Usuário é obrigatório");
        if (c.getData() == null) throw new RuntimeException("Data é obrigatória");
    }

    // Normaliza campos de texto da entidade Calendário
    private void normalizar(Calendario c) {
        // Nenhum campo textual obrigatório; manter para consistência
    }
}
