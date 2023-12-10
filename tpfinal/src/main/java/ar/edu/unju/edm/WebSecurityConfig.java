package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.edm.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private Autenticacion autenticacion;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/puntos", "/login").permitAll()
                        .requestMatchers("/css/**", "/fonts/**").permitAll()
                        .requestMatchers("/admin", "/addTurista", "/deleteTurista").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                ).formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .successHandler(autenticacion)
                        .failureUrl("/login?error=true")
                        .usernameParameter("nombre")
                        .passwordParameter("password")
                ).logout((logout) -> logout.logoutSuccessUrl("/login?logout").permitAll());

        return httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
