package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Calendario;
import com.enraizar.enraizar.Service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para operações de Calendário (retorna JSON)
@RestController
// Permite chamadas de outras origens (CORS)
@CrossOrigin
public class CalendarioController {

    // Serviço responsável pelas regras de negócio de Calendário
    private final CalendarioService servico;

    // Construtor com injeção de dependência do serviço
    @Autowired
    public CalendarioController(CalendarioService servico) {
        this.servico = servico;
    }

    // Lista todos os registros (GET /api/calendarios)
    @GetMapping("/api/calendarios")
    public List<Calendario> listarCalendarios() {
        return servico.listarCalendarios();
    }

    // Obtém um registro pelo ID (GET /api/calendarios/{id})
    @GetMapping("/api/calendarios/{id}")
    public Optional<Calendario> obterCalendarioPorId(@PathVariable Integer id) {
        return servico.obterCalendarioPorId(id);
    }

    // Lista registros por usuário (GET /api/calendarios/usuario/{idUsuario})
    @GetMapping("/api/calendarios/usuario/{idUsuario}")
    public List<Calendario> listarPorUsuario(@PathVariable Integer idUsuario) {
        return servico.listarPorUsuario(idUsuario);
    }

    // Cadastra um novo registro (POST /api/calendarios)
    @PostMapping("/api/calendarios")
    public void cadastrarCalendario(@RequestBody Calendario c) {
        servico.cadastrarCalendario(c);
    }

    // Atualiza um registro existente (PUT /api/calendarios)
    @PutMapping("/api/calendarios")
    public void atualizarCalendario(@RequestBody Calendario c) {
        servico.atualizarCalendario(c);
    }

    // Exclui um registro pelo ID (DELETE /api/calendarios/{id})
    @DeleteMapping("/api/calendarios/{id}")
    public void deletarCalendario(@PathVariable Integer id) {
        servico.deletarCalendario(id);
    }
}
