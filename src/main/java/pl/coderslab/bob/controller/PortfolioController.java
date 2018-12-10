package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bob.entity.*;
import pl.coderslab.bob.repository.HistoryRepository;
import pl.coderslab.bob.repository.InstrumentTypeRepository;
import pl.coderslab.bob.repository.PurchasedProductRepository;
import pl.coderslab.bob.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PortfolioController {

    private PurchasedProductRepository purchasedProductRepository;
    private InstrumentTypeRepository instrumentTypeRepository;
    private UserRepository userRepository;
    private HistoryRepository historyRepository;

    @Autowired
    public PortfolioController(PurchasedProductRepository purchasedProductRepository, InstrumentTypeRepository instrumentTypeRepository, UserRepository userRepository, HistoryRepository historyRepository) {
        this.purchasedProductRepository = purchasedProductRepository;
        this.instrumentTypeRepository = instrumentTypeRepository;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        List<InstrumentType> instrumentTypes = instrumentTypeRepository.findAll();

        for (InstrumentType instrumentType : instrumentTypes) {
            instrumentType.setSum(purchasedProductRepository.sumActiveProducts(instrumentType,user));
        }

        model.addAttribute("instrumentTypes", instrumentTypes);
        model.addAttribute("products", purchasedProductRepository.findPurchasedProductsActive(user));
        model.addAttribute("deposits",purchasedProductRepository.sumDeposits(user));
        model.addAttribute("credits",purchasedProductRepository.sumCredits(user));
        return "portfolio";
    }

    @GetMapping("/resetportfolio")
    public String reset() {
        return "deletePortfolio";
    }

    @PostMapping("resetportfolio")
    public String reset(HttpSession session, @Param("button") String button) {
        if ("yes".equals(button)) {
            User user = (User) session.getAttribute("user");
            List<PurchasedProduct> purchasedProducts = purchasedProductRepository.findPurchasedProductsActive(user);
            for (PurchasedProduct purchasedProduct : purchasedProducts) {
                purchasedProductRepository.delete(purchasedProduct);
                History history = new History();
                history.setPurchasedProduct(purchasedProduct);
                history.setOperation("deleted");
                history.setDate(LocalDateTime.now());
                historyRepository.save(history);
            }
        }
        return "redirect:/portfolio";
    }
}
