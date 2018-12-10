package pl.coderslab.bob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.bob.entity.User;
import pl.coderslab.bob.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    private UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register(@ModelAttribute User user) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result, @RequestParam String repassword,  Model model, HttpSession session) {
        if (!user.getPassword().equals(repassword) || result.hasErrors()) {
            model.addAttribute("wrong", "wrong password");
            return "register";
        }

        userRepository.save(user);
        session.setAttribute("user", user);
        return "redirect:portfolio";
    }

}
