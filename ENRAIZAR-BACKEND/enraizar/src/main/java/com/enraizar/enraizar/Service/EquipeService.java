package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Repo.EquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

	private final EquipeRepo repo;

	@Autowired
	public EquipeService(EquipeRepo repo) {
		this.repo = repo;
	}

	// Lista todas as equipes cadastradas

	public List<Equipe> listarEquipes() {
		return repo.findAll();
	}

	// Busca uma equipe pelo ID

	public Optional<Equipe> obterEquipePorId(Integer id) {
		return repo.findById(id);
	}

	// Busca uma equipe pelo nome

	public Optional<Equipe> obterEquipePorNome(String nome) {
		return repo.findByNome(nome);
	}

	// Cadastra uma nova equipe no banco Valida campos obrigatórios Verifica
	// duplicidade de nome Normaliza strings antes de salvar

	public void cadastrarEquipe(Equipe e) {
		validarObrigatorios(e);
		verificarNomeDuplicado(e.getNome(), null);
		normalizar(e);
		repo.save(e);
	}

	// Atualiza os dados de uma equipe existente
	// Valida ID
	// Verifica se equipe existe
	// Atualiza nome e descrição, mantendo consistência

	public void atualizarEquipe(Equipe e) {
		if (e.getId() == 0) {
			throw new RuntimeException("Id é obrigatório para atualizar a equipe");
		}

		// Busca equipe no banco
		Equipe atual = repo.findById(e.getId()).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

		// Atualiza nome se informado e não duplicado
		if (e.getNome() != null && !e.getNome().isBlank()) {
			verificarNomeDuplicado(e.getNome(), e.getId());
			atual.setNome(e.getNome().trim());
		}

		// Atualiza descrição se informada
		if (e.getDescrisao() != null) {
			atual.setDescrisao(e.getDescrisao().trim());
		}

		repo.save(atual);
	}

	// Exclui uma equipe pelo ID

	public void deletarEquipe(Integer id) {
		Equipe e = repo.findById(id).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
		repo.delete(e);
	}

	// Métodos auxiliares privados

	// Valida se campos obrigatórios estão preenchidos

	private void validarObrigatorios(Equipe e) {
		if (e.getNome() == null || e.getNome().isBlank()) {
			throw new RuntimeException("Nome é obrigatório");
		}
	}

	// Normaliza strings para evitar inconsistências (ex: espaços extras)

	private void normalizar(Equipe e) {
		e.setNome(e.getNome().trim());
		if (e.getDescrisao() != null) {
			e.setDescrisao(e.getDescrisao().trim());
		}
	}

	// Verifica se já existe outra equipe com o mesmo nome

	private void verificarNomeDuplicado(String nome, Integer idAtual) {
		Optional<Equipe> existente = repo.findByNome(nome.trim());
		if (existente.isPresent()) {
			// Se for novo cadastro ou atualização para nome de outra equipe
			if (idAtual == null || existente.get().getId() != idAtual) {
				throw new RuntimeException("Já existe uma equipe com esse nome");
			}
		}
	}
}
