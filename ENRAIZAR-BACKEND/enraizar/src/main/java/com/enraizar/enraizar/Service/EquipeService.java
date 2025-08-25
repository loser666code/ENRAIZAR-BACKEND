package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Repo.EquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço de regras de negócio para Equipe
@Service
public class EquipeService {

    // Repositório para acesso ao banco de dados de Equipe
    private final EquipeRepo repo;

    // Construtor com injeção de dependência do repositório
    @Autowired
    public EquipeService(EquipeRepo repo) {
        this.repo = repo;
    }

    // Lista todas as equipes
    public List<Equipe> listarEquipes() {
        return repo.findAll();
    }

    // Obtém uma equipe pelo ID
    public Optional<Equipe> obterEquipePorId(Integer id) {
        return repo.findById(id);
    }

    // Obtém uma equipe pelo nome
    public Optional<Equipe> obterEquipePorNome(String nome) {
        return repo.findByNome(nome);
    }

    // Cadastra uma nova equipe com validações
    public void cadastrarEquipe(Equipe e) {
        validarObrigatorios(e);                   // Garante campos obrigatórios
        normalizar(e);                            // Padroniza campos de texto
        verificarNomeDuplicado(e.getNome(), e.getId()); // Evita nome duplicado
        repo.save(e);
    }

    // Atualiza uma equipe existente com validações
    public void atualizarEquipe(Equipe e) {
        validarObrigatorios(e);                   // Garante campos obrigatórios
        normalizar(e);                            // Padroniza campos de texto
        verificarNomeDuplicado(e.getNome(), e.getId()); // Evita nome duplicado
        repo.save(e);
    }

    // Exclui uma equipe pelo ID
    public void deletarEquipe(Integer id) {
        repo.deleteById(id);
    }

    // Valida campos obrigatórios da entidade Equipe
    private void validarObrigatorios(Equipe e) {
        if (e == null) {
            throw new RuntimeException("Equipe não pode ser nula");
        }
        if (e.getNome() == null || e.getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }
    }

    // Normaliza campos de texto da entidade Equipe
    private void normalizar(Equipe e) {
        if (e.getNome() != null) {
            e.setNome(e.getNome().trim().toUpperCase());
        }
    }

    // Verifica se já existe outra equipe com o mesmo nome
    private void verificarNomeDuplicado(String nome, Integer idAtual) {
        Optional<Equipe> existente = repo.findByNome(nome.trim());
        if (existente.isPresent()) {
        	if (idAtual == null || existente.get().getId() != idAtual) {
				throw new RuntimeException("Já existe uma equipe com esse nome");
            }
        }
    }
}
