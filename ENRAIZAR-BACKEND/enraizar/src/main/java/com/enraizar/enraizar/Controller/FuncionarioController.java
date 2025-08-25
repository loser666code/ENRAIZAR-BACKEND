package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para operações de Funcionário (retorna JSON)
@RestController
// Permite chamadas de outras origens (CORS)
@CrossOrigin
public class FuncionarioController {

	// Serviço responsável pelas regras de negócio de Funcionário
	private final FuncionarioService servico;

	// Construtor com injeção de dependência do serviço
	@Autowired
	public FuncionarioController(FuncionarioService servico) {
		this.servico = servico;
	}

	// Retorna a página HTML de listagem (GET /funcionarios)
	@RequestMapping("/funcionarios")
	public String funcionariosPage() {
		return "listar-funcionarios.html";
	}

	// Cadastra um novo funcionário (POST)
	@PostMapping
	public void cadastrarFuncionario(@RequestBody Funcionario f) {
		servico.cadastrarFuncionario(f);
	}

	// Lista todos os funcionários (GET)
	@GetMapping
	public List<Funcionario> listarFuncionarios() {
		return servico.listarFuncionarios();
	}

	// Obtém um funcionário pelo ID (GET /id/{id})
	@GetMapping("/id/{id}")
	public Optional<Funcionario> obeterFuncionarioPorId(@PathVariable Integer id) {
		return servico.obeterFuncionarioPorId(id);
	}

	// Obtém um funcionário pelo nome (GET /nome/{nome})
	@GetMapping("/nome/{nome}")
	public Optional<Funcionario> obeterFuncionarioPorNome(@PathVariable String nome) {
		return servico.obeterFuncionarioPorNome(nome);
	}

	// Atualiza um funcionário existente (PUT)
	@PutMapping
	public void atualizarFuncionario(@RequestBody Funcionario f) {
		servico.atualizarFuncionario(f);
	}

	// Exclui um funcionário pelo ID (DELETE /{id})
	@DeleteMapping("/{id}")
	public void deletarFuncionario(@PathVariable Integer id) {
		servico.deletarFuncionario(id);
	}
}
