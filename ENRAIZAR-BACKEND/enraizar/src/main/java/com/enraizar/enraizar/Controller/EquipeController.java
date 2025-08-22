package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin // Permite chamadas de outros domínios (importante para integração com frontend)
public class EquipeController {

	private final EquipeService servico;

	@Autowired
	public EquipeController(EquipeService servico) {
		this.servico = servico;
	}

	// --- Rotas de API ---

	// Lista todas as equipes registradas no banco

	@GetMapping("/api/equipes")
	public List<Equipe> listarEquipes() {
		return servico.listarEquipes();
	}

	// Busca uma equipe específica pelo ID

	@GetMapping("/api/equipes/{id}")
	public Optional<Equipe> obterEquipePorId(@PathVariable Integer id) {
		return servico.obterEquipePorId(id);
	}

	// Busca uma equipe pelo nome

	@GetMapping("/api/equipes/nome/{nome}")
	public Optional<Equipe> obterEquipePorNome(@PathVariable String nome) {
		return servico.obterEquipePorNome(nome);
	}

	// Cria uma nova equipe

	@PostMapping("/api/equipes")
	public void cadastrarEquipe(@RequestBody Equipe e) {
		servico.cadastrarEquipe(e);
	}

	// Atualiza os dados de uma equipe existente

	@PutMapping("/api/equipes")
	public void atualizarEquipe(@RequestBody Equipe e) {
		servico.atualizarEquipe(e);
	}

	// Remove uma equipe pelo ID

	@DeleteMapping("/api/equipes/{id}")
	public void deletarEquipe(@PathVariable Integer id) {
		servico.deletarEquipe(id);
	}
}
