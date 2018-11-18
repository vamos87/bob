package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bob.entity.PurchasedProduct;

public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {

}
