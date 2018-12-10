package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bob.comparator.ProductComparator;
import pl.coderslab.bob.entity.InstrumentType;
import pl.coderslab.bob.entity.Product;
import pl.coderslab.bob.entity.PurchasedProduct;
import pl.coderslab.bob.entity.User;
import pl.coderslab.bob.repository.ProductRepository;
import pl.coderslab.bob.repository.PurchasedProductRepository;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {

    private PurchasedProductRepository purchasedProductRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(PurchasedProductRepository purchasedProductRepository, ProductRepository productRepository) {
        this.purchasedProductRepository = purchasedProductRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/more/{id}")
    public String productList(@PathVariable long id, Model model) {
        List<Product> products = productRepository.findByInstrumentTypeId(id);

        for (Product product : products) {
            product.setPopularity(purchasedProductRepository.countActiveProducts(id, product));
        }

        Collections.sort(products, new ProductComparator());
        model.addAttribute("productList", products);
        return "productList";
    }

    @GetMapping("/addMore/{id}")
    public String addProduct(@PathVariable long id, Model model) {
        Product product = productRepository.findOne(id);
        model.addAttribute("product", product);
        return "addMore";
    }

}
