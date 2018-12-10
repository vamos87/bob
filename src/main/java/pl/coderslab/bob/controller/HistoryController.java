package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.bob.entity.History;
import pl.coderslab.bob.entity.User;
import pl.coderslab.bob.repository.HistoryRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HistoryController {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping("/history")
    public String history(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("histories", historyRepository.findByUserOrderByDateDesc(user));
        return "history";
    }

    @GetMapping("/deletehistory")
    public String delete() {
        return "deleteHistory";
    }

    @PostMapping("/deletehistory")
    public String delete(HttpSession session, @Param("button") String button) {
        if ("yes".equals(button)) {
            User user = (User) session.getAttribute("user");
            List<History> histories = historyRepository.findByUserOrderByDateDesc(user);
            for (History history : histories) {
                historyRepository.delete(history);
            }
        }
        return "redirect:/history";
    }

}
