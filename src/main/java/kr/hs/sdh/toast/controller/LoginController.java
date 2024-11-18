package kr.hs.sdh.toast.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/register")
    private  String register(){return "register";}
    @GetMapping("/login")
    private String logIn(){return "Login";}
    @GetMapping("/home")
    private String home(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);

        return "home";
    }
}
