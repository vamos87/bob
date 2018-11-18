package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
