package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Equipe;
import com.enraizar.enraizar.Repo.EquipeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipeController {
    EquipeRepo repo;

    public EquipeController(EquipeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/equipes")
    public String listarEquipes (Model model){
        model.addAttribute("equipe", repo.findAll());
        return "equipes";
    }

    @GetMapping("adicionar-equipes")
    public String mostrarAdicionarEquipe(Model model){
        model.addAttribute("equipe", new Equipe());
        return "adicionar-equipes";
    }

    @PostMapping("/adicionar-equipes")
    public String adicionarEquipe(Equipe e){
        repo.save(e);
        return "redirect:/equipes";
    }
}
