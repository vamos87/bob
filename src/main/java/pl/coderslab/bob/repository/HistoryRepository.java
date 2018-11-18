package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
