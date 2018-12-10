package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.bob.entity.User;
import pl.coderslab.bob.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String user(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        return "user";
    }

    @PostMapping("/user")
    public String user(@Valid User user, BindingResult result, @RequestParam String repassword, Model model) {
        if (!user.getPassword().equals(repassword) || result.hasErrors()) {
            model.addAttribute("wrong", "wrong password");
            return "register";
        }

        userRepository.save(user);
        return "redirect;portfolio";
    }

    @GetMapping("/deleteuser")
    public String delete() {
        return "deleteUser";
    }

    @PostMapping("/deleteuser")
    public String delete(HttpSession session, @Param("button") String button) {
        if ("yes".equals(button)) {
            User user = (User) session.getAttribute("user");
            userRepository.delete(user);
            return "redirect:/";
        }
        return "redirect:/user";
    }
}
