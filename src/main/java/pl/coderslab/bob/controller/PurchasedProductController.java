package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bob.entity.*;
import pl.coderslab.bob.repository.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PurchasedProductController {

    private BankRepository bankRepository;
    private InstrumentTypeRepository instrumentTypeRepository;
    private ProductRepository productRepository;
    private PurchasedProductRepository purchasedProductRepository;
    private UserRepository userRepository;
    private HistoryRepository historyRepository;

    @Autowired
    public PurchasedProductController(BankRepository bankRepository, InstrumentTypeRepository instrumentTypeRepository,
                                      ProductRepository productRepository, PurchasedProductRepository purchasedProductRepository, UserRepository userRepository, HistoryRepository historyRepository) {
        this.bankRepository = bankRepository;
        this.instrumentTypeRepository = instrumentTypeRepository;
        this.productRepository = productRepository;
        this.purchasedProductRepository = purchasedProductRepository;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }


    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable long id, Model model) {
        InstrumentType instrumentType = instrumentTypeRepository.findOne(id);
        model.addAttribute("instrumentType", instrumentType);
        model.addAttribute("button", "add");
        model.addAttribute("products", productRepository.findByInstrumentType(instrumentType));
        return "addProduct";
    }

    @PostMapping("/add/**")
    public String addProduct(@Param("id") Long id, @Param("value") float value, @Param("note") String note, HttpSession session) {
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        User user = (User)session.getAttribute("user");
        purchasedProduct.setProduct(productRepository.findOne(id));
        purchasedProduct.setValue(value);
        purchasedProduct.setNote(note);
        purchasedProduct.setUser(user);
        purchasedProduct.setActive(true);
        purchasedProductRepository.save(purchasedProduct);
        History history = new History();
        history.setPurchasedProduct(purchasedProduct);
        history.setOperation("added");
        history.setValue(value);
        history.setDate(LocalDateTime.now());
        historyRepository.save(history);
        return "redirect:/portfolio";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable long id, Model model) {
        PurchasedProduct purchasedProduct = purchasedProductRepository.findOne(id);
        model.addAttribute("purchasedProduct", purchasedProduct);
        model.addAttribute("products", productRepository.findByInstrumentType(purchasedProduct.getProduct().getInstrumentType()));
        return "editProduct";
    }

    @PostMapping("/edit/**")
    public String editProduct(@Param("id") Long id, @Param("value") float value, @Param("note") String note, @Param("prod") Long prod) {
        PurchasedProduct purchasedProduct = purchasedProductRepository.findOne(id);
        purchasedProduct.setProduct(productRepository.findOne(prod));
        purchasedProduct.setValue(value);
        purchasedProduct.setNote(note);
        purchasedProductRepository.save(purchasedProduct);
        History history = new History();
        history.setPurchasedProduct(purchasedProduct);
        history.setOperation("edited");
        history.setValue(value);
        history.setDate(LocalDateTime.now());
        historyRepository.save(history);
        return "redirect:/portfolio";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        model.addAttribute("purchasedProduct", purchasedProductRepository.findOne(id));
        return "deleteProduct";
    }

    @PostMapping("/delete/**")
    public String deleteProduct(@Param("id") long id, @Param("button") String button) {
        if ("yes".equals(button)) {
            PurchasedProduct purchasedProduct = purchasedProductRepository.findOne(id);
            History history = new History();
            history.setValue(purchasedProduct.getValue());
            history.setPurchasedProduct(purchasedProduct);
            history.setOperation("deleted");
            history.setDate(LocalDateTime.now());
            historyRepository.save(history);
            purchasedProduct.setActive(false);
            purchasedProductRepository.delete(purchasedProduct);
        }
        return "redirect:/portfolio";
    }
}
