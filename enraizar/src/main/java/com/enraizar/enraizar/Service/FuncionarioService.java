package com.enraizar.enraizar.Service;

import com.enraizar.enraizar.Model.Funcionario;
import com.enraizar.enraizar.Repo.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepo repo;

    @Autowired
    public FuncionarioService(FuncionarioRepo repo) {
        this.repo = repo;
    }

    public void cadastrarFuncionario (Funcionario f){

        repo.save(f);
    }

    public List<Funcionario> listarFuncionarios(){
        return repo.findAll();
    }

    public void atualizarFuncionario (Funcionario f){
        repo.save(f);
    }

    public void deletarFuncionario(Integer id){
        repo.deleteById(id);
    }

    public Optional<Funcionario> obeterFuncionarioPorId(Integer id){
        return repo.findById(id);
    }

    public Optional<Funcionario> obeterFuncionarioPorNome(String nome){
        return repo.findByNome(nome);
    }

    private void verificarCPF(String cpf, Integer id){
        boolean cpfUsado;
        if(id == null){
            cpfUsado = repo.findByCpf(cpf).isPresent();
        } else {
            cpfUsado = repo.existsByCpfAndId(cpf,id);
        }

        if (cpfUsado){
            throw new RuntimeException("Esse CPF já esta sendo utilizado");
        }
    }

    private void verificarEmail(String email, Integer id){
        boolean emailUsado;
        if(id == null){
            emailUsado = repo.findByEmail(email).isPresent();
        } else {
            emailUsado = repo.existsByEmailAndId(email,id);
        }

        if (emailUsado){
            throw new RuntimeException("Esse Email já esta sendo utilizado");
        }
    }
}
