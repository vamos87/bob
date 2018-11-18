package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
