package com.crisilto.userapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //Deshabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  //Permite acceso a la consola H2
                        .requestMatchers("/products/**", "/users/**").hasRole("USER") //Permite a usuarios con rol USER
                        .requestMatchers("/products/delete/**", "/users/delete/**").hasRole("ADMIN") //Solo ADMIN puede eliminar
                        .anyRequest().authenticated()  //Requiere autenticación para todas las demás solicitudes
                )
                .httpBasic(withDefaults());  //Utiliza autenticación básica

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password") // "{noop}" indica que no se aplicará ningún algoritmo de encriptación
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
