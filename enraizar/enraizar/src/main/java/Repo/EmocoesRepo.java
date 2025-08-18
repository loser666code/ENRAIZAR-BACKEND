package Repo;

import Model.Emocoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmocoesRepo extends JpaRepository<Emocoes,Integer> {
}
