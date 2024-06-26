package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.builder()
                .username("kawsur")
                .password("$2y$10$LqPYTOcJhvhV7oSWXG5L2OkVMdQ4F0IbBxCP1Eyh2eqD7n8qgRhU6")
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/vendor/**","/WEV-INF/**","/views/**",
                        "/entrepreneur/show","/entrepreneur/submit","/entrepreneur/forgotpass",
                        "/entrepreneur/resetpass","/investor/show","/investor/submit").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/entrepreneur/login")
                .permitAll()
                .defaultSuccessUrl("/home/index", true)
                .and()
                .logout()
                .logoutSuccessUrl("/entrepreneur/login")
                .invalidateHttpSession(true)
                .permitAll();
        return http.build();
    }
}
