package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Repo.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço de regras de negócio para Funcionário
@Service
public class FuncionarioService {

	// Repositório para acesso ao banco de dados de Funcionário
	private final FuncionarioRepo repo;

	// Construtor com injeção de dependência do repositório
	@Autowired
	public FuncionarioService(FuncionarioRepo repo) {
		this.repo = repo;
	}

	// Cadastra um novo funcionário com validações de unicidade
	public void cadastrarFuncionario(Funcionario f) {
		verificarCPF(f.getCpf(), f.getId()); // Evita CPF duplicado
		verificarEmail(f.getEmail(), f.getId()); // Evita e-mail duplicado
		repo.save(f);
	}

	// Lista todos os funcionários
	public List<Funcionario> listarFuncionarios() {
		return repo.findAll();
	}

	// Atualiza um funcionário existente com validações de unicidade
	public void atualizarFuncionario(Funcionario f) {
		verificarCPF(f.getCpf(), f.getId()); // Evita CPF duplicado
		verificarEmail(f.getEmail(), f.getId()); // Evita e-mail duplicado
		repo.save(f);
	}

	// Exclui um funcionário pelo ID
	public void deletarFuncionario(Integer id) {
		repo.deleteById(id);
	}

	// Obtém um funcionário pelo ID (nome do método mantido)
	public Optional<Funcionario> obeterFuncionarioPorId(Integer id) {
		return repo.findById(id);
	}

	// Obtém um funcionário pelo nome (nome do método mantido)
	public Optional<Funcionario> obeterFuncionarioPorNome(String nome) {
		return repo.findByNome(nome);
	}

	// Verifica duplicidade de CPF
	private void verificarCPF(String cpf, Integer id) {
		boolean cpfUsado;
		if (id == null) { // Novo cadastro
			cpfUsado = repo.findByCpf(cpf).isPresent();
		} else { // Atualização de registro existente
			cpfUsado = repo.existsByCpfAndId(cpf, id);
		}
		if (cpfUsado) {
			throw new RuntimeException("Esse CPF já esta sendo utilizado");
		}
	}

	// Verifica duplicidade de e-mail
	private void verificarEmail(String email, Integer id) {
		boolean emailUsado;
		if (id == null) { // Novo cadastro
			emailUsado = repo.findByEmail(email).isPresent();
		} else { // Atualização de registro existente
			emailUsado = repo.existsByEmailAndId(email, id);
		}
		if (emailUsado) {
			throw new RuntimeException("Esse Email já esta sendo utilizado");
		}
	}
}
