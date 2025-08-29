package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.Calendario;
import com.enraizar.enraizar.Model.CalendarioEmocoes;
import com.enraizar.enraizar.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarioEmocoesRepo extends JpaRepository<CalendarioEmocoes,Integer> {

}
