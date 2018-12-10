package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.bob.entity.User;
import pl.coderslab.bob.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String auth(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userRepository.findByEmailIgnoreCaseAndPassword(email,password);
        if (user == null) {
            return "/login";
        }
        session.setAttribute("user", user);
        return "redirect:portfolio";
    }

    @GetMapping("/signout")
    public String signOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
