package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.CalendarioEmocao;
import com.enraizar.enraizar.Service.CalendarioEmocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para operações de Calendário-Emoções (retorna JSON)
@RestController
// Permite chamadas de outras origens (CORS)
@CrossOrigin
public class CalendarioEmocaoController {

    // Serviço responsável pelas regras de negócio de Calendário-Emoções
    private final CalendarioEmocaoService servico;

    // Construtor com injeção de dependência do serviço
    @Autowired
    public CalendarioEmocaoController(CalendarioEmocaoService servico) {
        this.servico = servico;
    }

    // Lista todos os vínculos (GET /api/calendario-emocoes)
    @GetMapping("/api/calendario-emocoes")
    public List<CalendarioEmocao> listarTodos() {
        return servico.listarTodos();
    }

    // Lista vínculos por calendário (GET /api/calendario-emocoes/calendario/{idCalendario})
    @GetMapping("/api/calendario-emocoes/calendario/{idCalendario}")
    public List<CalendarioEmocao> listarPorCalendario(@PathVariable Integer idCalendario) {
        return servico.listarPorCalendario(idCalendario);
    }

    // Obtém um vínculo específico (GET /api/calendario-emocoes/{idCalendario}/{idEmocao})
    @GetMapping("/api/calendario-emocoes/{idCalendario}/{idEmocao}")
    public Optional<CalendarioEmocao> obterVinculo(@PathVariable Integer idCalendario,
                                                   @PathVariable Integer idEmocao) {
        return servico.obterVinculo(idCalendario, idEmocao);
    }

    // Cadastra um novo vínculo (POST /api/calendario-emocoes)
    @PostMapping("/api/calendario-emocoes")
    public void cadastrar(@RequestBody CalendarioEmocao ce) {
        servico.cadastrar(ce);
    }

    // Atualiza um vínculo (PUT /api/calendario-emocoes)
    @PutMapping("/api/calendario-emocoes")
    public void atualizar(@RequestBody CalendarioEmocao ce) {
        servico.atualizar(ce);
    }

    // Exclui um vínculo (DELETE /api/calendario-emocoes/{idCalendario}/{idEmocao})
    @DeleteMapping("/api/calendario-emocoes/{idCalendario}/{idEmocao}")
    public void deletar(@PathVariable Integer idCalendario, @PathVariable Integer idEmocao) {
        servico.deletar(idCalendario, idEmocao);
    }
}
