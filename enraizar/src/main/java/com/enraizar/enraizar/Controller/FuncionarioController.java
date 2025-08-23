package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Repo.FuncionarioRepo;
import com.enraizar.enraizar.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FuncionarioController {

    private final FuncionarioService servico;
    private final FuncionarioRepo repo;
    @Autowired
    public FuncionarioController(FuncionarioService servico, FuncionarioRepo repo) {

        this.servico = servico;
        this.repo = repo;
    }

// -- cadastrar funcionario!
    @GetMapping("/adicionar-funcionario")
    public String mostrarCadastro (Model model){
        model.addAttribute("funcionario",new Funcionario());
        List<String> tipoUsuario = List.of("Administrador", "Colaborador");
        model.addAttribute("tipos", tipoUsuario);
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarFuncionario (Funcionario f, Model model){
        servico.cadastrarFuncionario(f);
        return "redirect:/lista";
    }

// -- listar funcionarios
    @GetMapping("/lista")
        public String listarFuncionarios(Model model){
        model.addAttribute("funcionarios", servico.listarFuncionarios());
        return "lista";
    }

    @GetMapping("/id/{id}")
    public Optional<Funcionario> obterFuncionarioPorId (@PathVariable Integer id){
        return servico.obeterFuncionarioPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Funcionario> obterFuncionarioPorNome (@PathVariable String nome){
        return servico.obeterFuncionarioPorNome(nome);
    }

    @GetMapping("/editar/{id}")
    public String editarFuncionario(@PathVariable("id") int id, Model model){
        Funcionario f = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id invalido!:" + id));
        List<String> tipoUsuario = List.of("Administrador", "Colaborador");
        model.addAttribute("tipos", tipoUsuario);
        model.addAttribute("funcionario", f);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarFuncionario(@PathVariable("id") int id, Funcionario f){
        servico.atualizarFuncionario(f);
        return "redirect:/lista";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionario (@PathVariable ("id") int id, Model model){
        Funcionario f = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido!:" + id));
        repo.delete(f);
        return "redirect:/lista";
    }
}
