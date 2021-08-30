package ua.goit.goitnotes.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class MainController {

    @GetMapping
    public String doGet() {
        log.info("I'm rendering the \"index\" page");
        return "index";
    }

    @PostMapping
    public String doPost() {
        return "index";
    }

    @GetMapping("login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username or password is invalid");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out");
        }

        return "login";
    }

}
