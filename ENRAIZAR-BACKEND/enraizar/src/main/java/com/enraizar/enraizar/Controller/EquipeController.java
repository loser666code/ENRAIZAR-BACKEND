package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para operações de Equipe (retorna JSON)
@RestController
// Permite chamadas de outras origens (CORS)
@CrossOrigin
public class EquipeController {

	// Serviço responsável pelas regras de negócio de Equipe
	private final EquipeService servico;

	// Construtor com injeção de dependência do serviço
	@Autowired
	public EquipeController(EquipeService servico) {
		this.servico = servico;
	}

	// Lista todas as equipes (GET /api/equipes)
	@GetMapping("/api/equipes")
	public List<Equipe> listarEquipes() {
		return servico.listarEquipes();
	}

	// Obtém uma equipe pelo ID (GET /api/equipes/{id})
	@GetMapping("/api/equipes/{id}")
	public Optional<Equipe> obterEquipePorId(@PathVariable Integer id) {
		return servico.obterEquipePorId(id);
	}

	// Obtém uma equipe pelo nome (GET /api/equipes/nome/{nome})
	@GetMapping("/api/equipes/nome/{nome}")
	public Optional<Equipe> obterEquipePorNome(@PathVariable String nome) {
		return servico.obterEquipePorNome(nome);
	}

	// Cadastra uma nova equipe (POST /api/equipes)
	@PostMapping("/api/equipes")
	public void cadastrarEquipe(@RequestBody Equipe e) {
		servico.cadastrarEquipe(e);
	}

	// Atualiza uma equipe existente (PUT /api/equipes)
	@PutMapping("/api/equipes")
	public void atualizarEquipe(@RequestBody Equipe e) {
		servico.atualizarEquipe(e);
	}

	// Exclui uma equipe pelo ID (DELETE /api/equipes/{id})
	@DeleteMapping("/api/equipes/{id}")
	public void deletarEquipe(@PathVariable Integer id) {
		servico.deletarEquipe(id);
	}
}

