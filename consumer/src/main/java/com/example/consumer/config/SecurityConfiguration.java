//package com.example.consumer.config;
//
//import com.example.consumer.util.handler.CustomAccessDeniedHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final AccessDeniedHandler accessDeniedHandler;
//
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//
//    // роль admin всегда есть доступ к /admin/**
//    // роль user всегда есть доступ к /user/**
//    // Наш кастомный "403 access denied" обработчик
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/index", "/about").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//    }
//
//    // создаем пользоватлелей, admin и user
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }
//}
