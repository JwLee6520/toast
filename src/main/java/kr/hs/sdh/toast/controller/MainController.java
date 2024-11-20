package kr.hs.sdh.toast.controller;

import kr.hs.sdh.toast.model.CustomerDeatails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/")
    private String index(@AuthenticationPrincipal CustomerDeatails customerDeatails, Model model){
        model.addAttribute("user", customerDeatails);
        return "home";
    }
}
