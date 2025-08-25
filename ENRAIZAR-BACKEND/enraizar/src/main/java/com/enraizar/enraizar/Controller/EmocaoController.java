package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Emocao;
import com.enraizar.enraizar.Service.EmocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para operações de Emoção (retorna JSON)
@RestController
// Permite chamadas de outras origens (CORS)
@CrossOrigin
public class EmocaoController {

    // Serviço responsável pelas regras de negócio de Emoção
    private final EmocaoService servico;

    // Construtor com injeção de dependência do serviço
    @Autowired
    public EmocaoController(EmocaoService servico) {
        this.servico = servico;
    }

    // Lista todas as emoções (GET /api/emocoes)
    @GetMapping("/api/emocoes")
    public List<Emocao> listarEmocoes() {
        return servico.listarEmocoes();
    }

    // Obtém uma emoção pelo ID (GET /api/emocoes/{id})
    @GetMapping("/api/emocoes/{id}")
    public Optional<Emocao> obterEmocaoPorId(@PathVariable Integer id) {
        return servico.obterEmocaoPorId(id);
    }

    // Obtém uma emoção pela descrição (GET /api/emocoes/descricao/{descricao})
    @GetMapping("/api/emocoes/descricao/{descricao}")
    public Optional<Emocao> obterEmocaoPorDescricao(@PathVariable String descricao) {
        return servico.obterEmocaoPorDescricao(descricao);
    }

    // Cadastra uma nova emoção (POST /api/emocoes)
    @PostMapping("/api/emocoes")
    public void cadastrarEmocao(@RequestBody Emocao e) {
        servico.cadastrarEmocao(e);
    }

    // Atualiza uma emoção existente (PUT /api/emocoes)
    @PutMapping("/api/emocoes")
    public void atualizarEmocao(@RequestBody Emocao e) {
        servico.atualizarEmocao(e);
    }

    // Exclui uma emoção pelo ID (DELETE /api/emocoes/{id})
    @DeleteMapping("/api/emocoes/{id}")
    public void deletarEmocao(@PathVariable Integer id) {
        servico.deletarEmocao(id);
    }
}
