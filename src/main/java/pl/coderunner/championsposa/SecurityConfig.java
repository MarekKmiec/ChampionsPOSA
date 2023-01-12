package pl.coderunner.championsposa;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/user/**").hasAnyRole("USER")
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .defaultSuccessUrl("/register")
                .defaultSuccessUrl("/index");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




