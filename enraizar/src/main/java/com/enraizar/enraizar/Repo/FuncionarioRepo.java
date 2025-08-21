package com.enraizar.enraizar.Repo;

import com.enraizar.enraizar.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepo extends JpaRepository<Funcionario,Integer> {
    Optional<Funcionario> findById(Integer id);
    Optional<Funcionario> findByNome(String nome);
    Optional<Funcionario>findByCpf(String cpf);
    Optional<Funcionario>findByEmail(String email);
    Boolean existsByCpfAndId(String cpf, Integer id);
    Boolean existsByEmailAndId(String email, Integer id);
}
