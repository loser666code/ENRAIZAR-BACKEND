package Repo;

import Model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepo extends JpaRepository<Calendario, Integer> {
}
