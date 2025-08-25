package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Emocao;
import com.enraizar.enraizar.Repo.EmocaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço de regras de negócio para Emoção
@Service
public class EmocaoService {

    // Repositório para acesso ao banco de dados de Emoção
    private final EmocaoRepo repo;

    // Construtor com injeção de dependência do repositório
    @Autowired
    public EmocaoService(EmocaoRepo repo) {
        this.repo = repo;
    }

    // Lista todas as emoções
    public List<Emocao> listarEmocoes() {
        return repo.findAll();
    }

    // Obtém uma emoção pelo ID
    public Optional<Emocao> obterEmocaoPorId(Integer id) {
        return repo.findById(id);
    }

    // Obtém uma emoção pela descrição
    public Optional<Emocao> obterEmocaoPorDescricao(String descricao) {
        return repo.findByDescricao(descricao);
    }

    // Cadastra uma nova emoção com validações
    public void cadastrarEmocao(Emocao e) {
        validarObrigatorios(e);
        normalizar(e);
        verificarFaixaValor(e.getValor());
        repo.save(e);
    }

    // Atualiza uma emoção existente com validações
    public void atualizarEmocao(Emocao e) {
        validarObrigatorios(e);
        normalizar(e);
        verificarFaixaValor(e.getValor());
        repo.save(e);
    }

    // Exclui uma emoção pelo ID
    public void deletarEmocao(Integer id) {
        repo.deleteById(id);
    }

    // Valida campos obrigatórios da entidade Emoção
    private void validarObrigatorios(Emocao e) {
        if (e == null) throw new RuntimeException("Emoção não pode ser nula");
        if (e.getDescricao() == null || e.getDescricao().trim().isEmpty())
            throw new RuntimeException("Descrição é obrigatória");
        if (e.getValor() == null)
            throw new RuntimeException("Valor é obrigatório");
    }

    // Normaliza campos de texto da entidade Emoção
    private void normalizar(Emocao e) {
        if (e.getDescricao() != null) e.setDescricao(e.getDescricao().trim());
    }

    // Verifica se o valor está na faixa permitida (0 a 10)
    private void verificarFaixaValor(Integer valor) {
        if (valor < 0 || valor > 10) throw new RuntimeException("Valor deve estar entre 0 e 10");
    }
}
