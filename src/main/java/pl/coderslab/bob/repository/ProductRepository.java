package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.bob.entity.InstrumentType;
import pl.coderslab.bob.entity.Product;
import pl.coderslab.bob.entity.PurchasedProduct;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByInstrumentType(InstrumentType instrumentType);

    List<Product> findByInstrumentTypeId(Long id);

    Product getProductById(Long id);

//    @Query("SELECT p FROM Product p WHERE p.instrumentType.id = :id ")
//    List<Product> findProductByInstrumnetTypeId(@Param("id") Long id);

}
