package Service;

import Model.Funcionario;
import Repo.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FuncionarioService {

    private final FuncionarioRepo repo;

    @Autowired
    public FuncionarioService(FuncionarioRepo repo) {
        this.repo = repo;
    }

    public void cadastrarFuncionario(Funcionario f){
        if(repo.findByCPF(f.getCPF()).isPresent()){
            throw new RuntimeException("Já existe um funcionario com esse CPF");
        }
        if(repo.findByEmail(f.getEmail()).isPresent()){
            throw new RuntimeException("Já existe um funcionario com esse Email");
        }
        repo.save(f);
    }

    public List<Funcionario> listarFuncionarios(){
        return  repo.findAll();
    }

    public Optional<Funcionario> obterFuncionarPorCPF (String CPF){
        return repo.findByCPF(CPF);
    }

    public void atualizarFuncionario (Funcionario f){
        if (repo.existisFuncionarioByCPFNot(f.getCPF(),f.getId())){
            throw new RuntimeException("Já existe um funcionario com esse CPF");
        }
        if (repo.existisFuncionarioByEmailNot(f.getEmail(),f.getId())){
            throw new RuntimeException("Já existe um funcionario com esse Email");
        }

        repo.save(f);
    }

    public void deletarFuncionario(int id){
        repo.deleteById(id);
    }

}
