package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Model.EquipeUsuarios;
import com.enraizar.enraizar.Repo.EquipeRepo;
import com.enraizar.enraizar.Repo.EquipeUsuarioRepo;
import com.enraizar.enraizar.Repo.FuncionarioRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EquipeUsuarioController {
    EquipeUsuarioRepo repo;
    FuncionarioRepo funcionarioRepo;
    EquipeRepo equipeRepo;

    public EquipeUsuarioController(EquipeUsuarioRepo repo, FuncionarioRepo funcionarioRepo, EquipeRepo equipeRepo) {
        this.repo = repo;
        this.funcionarioRepo = funcionarioRepo;
        this.equipeRepo = equipeRepo;
    }

    @GetMapping("/equipe-membros/{id}")
    public String listarMmebros (@PathVariable("id") int id, Model model){
        List<EquipeUsuarios> membros = repo.findByEquipeId(id);
        model.addAttribute("membros",membros);
        return "equipe-membros";
    }

    @GetMapping("/adicionar-membro/{id}")
    public String adicionarMembro (@PathVariable("id") int id, Model model){
        Equipe equipe = equipeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipe invalida!"));
        EquipeUsuarios membro = new EquipeUsuarios();
        membro.setEquipe(equipe);
        model.addAttribute("funcionarios",funcionarioRepo.findAll());
        model.addAttribute("membro",membro);
        return "adicionar-membro";
    }

    @PostMapping("/adicionar-membro/{id}")
    public String cadastrarMembro(@PathVariable("id") int id, @ModelAttribute EquipeUsuarios membro){
        Equipe equipe = equipeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipe invalida!"));
        membro.setEquipe(equipe);
        repo.save(membro);
        return "redirect:/equipe-membros/"+id;
    }

    @GetMapping("/atualizar-membro/{id}")
    public String editarMembro (@PathVariable("id") int id, Model model){
        EquipeUsuarios membro = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido:" + id));
        model.addAttribute("membro",membro);
        return "editar-membro";
    }

    @PostMapping("/editar-membro/{id}")
    public String atualizarMembro(@PathVariable("id") int id, @ModelAttribute EquipeUsuarios membroForm){
        EquipeUsuarios membro = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido:" + id));
        membro.setCargo(membroForm.getCargo());
        int idEquipe = membro.getEquipe().getId();
        repo.save(membro);
        return "redirect:/equipe-membros/"+idEquipe;
    }

    @GetMapping("/deletar-membro/{id}")
    public String excluirMembro(@PathVariable("id") int id, Model model){
        EquipeUsuarios membro = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido:" + id));
        int idEquipe = membro.getEquipe().getId();
        repo.delete(membro);
        return "redirect:/equipe-membros/"+idEquipe;
    }
}
