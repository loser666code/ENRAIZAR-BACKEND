package Repo;

import Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByCPF(String CPF);
    Optional<Funcionario> findByEmail(String email);
    Boolean existisFuncionarioByCPFNot(String CPF, int id);
    Boolean existisFuncionarioByEmailNot(String Email, int id);
}
