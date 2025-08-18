package Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private FuncionarioSecurityDetails userDtailsService;

    public SecurityConfig(FuncionarioSecurityDetails userDtailsService) {
        this.userDtailsService = userDtailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/css/**","/js/**")
                .permitAll().anyRequest().authenticated()).formLogin(form -> form.loginPage("/html/login.html")
                .loginProcessingUrl("/peform_login")
                .usernameParameter("email")
                .passwordParameter("senha")
                .defaultSuccessUrl("/html/home.html",true).permitAll()).logout(logout -> logout.permitAll());
        return http.build();
    }
}
