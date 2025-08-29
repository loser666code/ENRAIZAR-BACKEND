package com.enraizar.enraizar.Controller;

import com.enraizar.enraizar.Model.Calendario;
import com.enraizar.enraizar.Model.CalendarioEmocoes;
import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Repo.CalendarioEmocoesRepo;
import com.enraizar.enraizar.Repo.CalendarioRepo;
import com.enraizar.enraizar.Repo.EmocoesRepo;
import com.enraizar.enraizar.Repo.FuncionarioRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
@RequestMapping("/calendario")
public class CalendarioController {

    CalendarioRepo calendarioRepo;
    CalendarioEmocoesRepo repo;
    FuncionarioRepo funcionarioRepo;
    EmocoesRepo emocaoRepo;

    public CalendarioController(CalendarioRepo calendarioRepo, CalendarioEmocoesRepo repo,
                                FuncionarioRepo funcionarioRepo, EmocoesRepo emocaoRepo) {
        this.calendarioRepo = calendarioRepo;
        this.repo = repo;
        this.funcionarioRepo = funcionarioRepo;
        this.emocaoRepo = emocaoRepo;
    }

    @GetMapping("/{id}")
    public String verCalendario(@PathVariable("id") int id, Model model){
        Funcionario funcionario = funcionarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido" + id));
        Calendario calendario = new Calendario(funcionario);
        model.addAttribute("calendario", calendario);
        model.addAttribute("funcionario",funcionario);
        return "calendario";
    }

    @PostMapping("/{id}/emocao/{idEmocao}")
    public String salvarHumor(@PathVariable("id") int id, @PathVariable("idEmocao") int idEmocao) {
        Funcionario funcionario = funcionarioRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id invalido" + id));
        Calendario calendario = new Calendario(funcionario);
        calendarioRepo.save(calendario);
        CalendarioEmocoes ce = new CalendarioEmocoes();
        ce.setCalendario(calendario);
        ce.setEmocao(emocaoRepo.findById(idEmocao).get());
        repo.save(ce);
        return "redirect:/calendario/" + id;
    }

}
