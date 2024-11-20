package kr.hs.sdh.toast.config;

import kr.hs.sdh.toast.entity.Bank;
import kr.hs.sdh.toast.entity.BankAccount;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.model.CustomerDeatails;
import kr.hs.sdh.toast.repository.BankAccountRepository;
import kr.hs.sdh.toast.repository.BankBookRepository;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfiguration {
    private final LoginRepository loginRepository;
    private final BankAccountRepository bankAccountRepository;
    public SecurityConfiguration(LoginRepository loginRepository, BankAccountRepository bankAccountRepository){
        this.loginRepository = loginRepository; this.bankAccountRepository = bankAccountRepository;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/images/**", "/styles/**").permitAll();
                    registry.requestMatchers("/login", "/register").anonymous();
                    registry.anyRequest().authenticated();
                })
                .formLogin(config ->{
                    config.passwordParameter("password");
                    config.usernameParameter("id");
                    config.loginPage("/login");
                    config.loginProcessingUrl("/login");
                    config.defaultSuccessUrl("/home");
                    config.failureUrl("/login");
                }).
                userDetailsService(id-> {
                    Customer customer = this.loginRepository.findId(id);
                    if (customer == null) {
                        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");

                    }
                    final String identity = customer.getPeople().getIdentity();
                    final List<BankAccount> bankAccount = this.bankAccountRepository.findAllByIdentity(identity);
                    return new CustomerDeatails(customer, bankAccount);
                })
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.contentEquals(rawPassword);
            }
        };
    }

}
