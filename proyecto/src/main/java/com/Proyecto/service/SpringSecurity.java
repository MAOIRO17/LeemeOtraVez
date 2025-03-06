// package com.Proyecto.service;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SpringSecurity {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/admin/**", "/libros/**").hasRole("ADMIN")
//                 .anyRequest().authenticated()
//             )
//             .formLogin(login -> login
//                 .loginPage("/usuario/login")
//                 .defaultSuccessUrl("/usuario/acceder", true)
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/usuario/login?logout")
//                 .permitAll()
//             );

//         return http.build();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
