package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FuncionarioController {
    @RequestMapping("/funcionarios")
    public String funcionariosPage(){
        return "listar-funcionarios.html";
    }


    private final FuncionarioService servico;
    @Autowired
    public FuncionarioController(FuncionarioService servico) {
        this.servico = servico;
    }
    @PostMapping
    public void cadastrarFuncionario (@RequestBody Funcionario f){
        servico.cadastrarFuncionario(f);
    }

    @GetMapping
        public List<Funcionario> listarFuncionarios(){
        return servico.listarFuncionarios();
    }

    @GetMapping("/id/{id}")
    public Optional<Funcionario> obterFuncionarioPorId (@PathVariable Integer id){
        return servico.obeterFuncionarioPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Funcionario> obterFuncionarioPorNome (@PathVariable String nome){
        return servico.obeterFuncionarioPorNome(nome);
    }

    @PutMapping
    public void atualizarFuncionario(@RequestBody Funcionario f){
        servico.atualizarFuncionario(f);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario (@PathVariable Integer id){
        servico.deletarFuncionario(id);
    }
}
