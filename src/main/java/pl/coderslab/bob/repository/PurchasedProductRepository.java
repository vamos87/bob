package pl.coderslab.bob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.bob.entity.InstrumentType;
import pl.coderslab.bob.entity.Product;
import pl.coderslab.bob.entity.PurchasedProduct;
import pl.coderslab.bob.entity.User;

import java.util.List;

public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {

    @Query("SELECT p FROM PurchasedProduct p WHERE p.isActive = true AND p.user = :user ORDER BY p.id DESC ")
    List<PurchasedProduct> findPurchasedProductsActive(@Param("user") User user);

    @Query("SELECT coalesce(sum(p.value),0) FROM PurchasedProduct p WHERE p.isActive = true AND p.product.instrumentType = :instrumentType AND p.user = :user")
    float sumActiveProducts(@Param("instrumentType")InstrumentType instrumentType, @Param("user") User user);

    @Query("SELECT count(distinct p.id) FROM PurchasedProduct p WHERE p.isActive = true AND p.product.instrumentType.id = :id AND p.product = :product ")
    long countActiveProducts(@Param("id") Long id, @Param("product")Product product);

    @Query("SELECT coalesce(sum(p.value),0) FROM PurchasedProduct p WHERE p.user = :user AND p.isActive = true " +
            "AND p.product.instrumentType.name IN ('current account','savings account','term deposit')")
    float sumDeposits(@Param("user") User user);

    @Query("SELECT coalesce(sum(p.value),0) FROM PurchasedProduct p WHERE p.user = :user AND p.isActive = true " +
            "AND p.product.instrumentType.name IN ('mortgage','other loan','credit card')")
    float sumCredits(@Param("user") User user);

}
