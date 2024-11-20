package kr.hs.sdh.toast.controller;

import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.LoginInfo;
import kr.hs.sdh.toast.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginRestController {
    private LoginService loginService;

    public LoginRestController(LoginService loginService){
        this.loginService = loginService;
    }
    @PostMapping("/register")
    private void register(Customer customer){
        this.loginService.getInfo(customer);
    }

}
