package kr.hs.sdh.toast.config;

import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    private final LoginRepository loginRepository;
    public SecurityConfiguration(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http

                .formLogin(config ->{
                    config.passwordParameter("password");
                    config.usernameParameter("id");
                    config.loginPage("/login");
                    config.loginProcessingUrl("/login");
                    config.defaultSuccessUrl("/home");
                    config.failureUrl("/login");
                }).
                userDetailsService(id->{
                    Customer customer = this.loginRepository.findId(id);
                    if(customer == null){
                        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
                    }
                    return User.withUsername(customer.getId())
                            .password(customer.getPassword())
                            .build();
                })
                .csrf(config -> config.disable())
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
