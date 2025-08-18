package Service;

import Model.Setor;
import Repo.SetorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SetorService {

    private final SetorRepo repo;

    @Autowired
    public SetorService(SetorRepo repo) {
        this.repo = repo;
    }

    public void criarSetor (Setor s){
        repo.save(s);
    }

    public List<Setor> listeSetores(){
        return repo.findAll();
    }

    public Optional<Setor> obterSetorPorId (int id){
        return repo.findById(id);
    }

    public void atualizarSetor(Setor s){
        repo.save(s);
    }

    public void deletarSetor (Setor s){
        repo.delete(s);
    }

}
