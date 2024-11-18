package kr.hs.sdh.toast.service;

import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Customer getId(String id , String password) {
        return this.loginRepository.findId(id);
    }

    public void getInfo(Customer customer){
        this.loginRepository.UserInfo(customer);
    }

}
