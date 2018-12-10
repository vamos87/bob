package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank getBankById(long id);
}
