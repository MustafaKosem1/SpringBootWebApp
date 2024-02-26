package com.ilan.demo.security;

import com.ilan.demo.business.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(IUserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                //.requestMatchers("/home/**").permitAll()
                                .requestMatchers("/ad/remove").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/ad/remove/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/ad/save").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/ad/update").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/ad/update/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/remove").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/remove/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/update").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/update/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/save").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/home/ad/save/process").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/**").permitAll()
                                .anyRequest().authenticated()
                )
                //.csrf(csrf -> csrf.disable())
                .formLogin(form ->
                        form
                                .successHandler(new SimpleUrlAuthenticationSuccessHandler("/home/ad"))
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
