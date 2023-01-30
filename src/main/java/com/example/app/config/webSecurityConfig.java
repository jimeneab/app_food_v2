package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/customer/**")
                .hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated();

        return http.build();
    }
}
