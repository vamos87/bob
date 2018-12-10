package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.bob.entity.History;
import pl.coderslab.bob.entity.User;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("SELECT h FROM History h WHERE h.purchasedProduct.user = :user ORDER BY h.date DESC ")
    List<History> findByUserOrderByDateDesc(@Param("user") User user);
}
