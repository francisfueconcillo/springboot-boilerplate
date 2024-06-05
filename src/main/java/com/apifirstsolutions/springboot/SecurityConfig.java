package com.apifirstsolutions.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apifirstsolutions.springboot.filters.FirstCustomFilter;
import com.apifirstsolutions.springboot.filters.SecondCustomFilter;

@Configuration
// @EnableWebSecurity
public class SecurityConfig {

    @Bean
    public FirstCustomFilter firstCustomFilter() {
        return new FirstCustomFilter();
    }

    @Bean
    public SecondCustomFilter secondCustomFilter() {
        return new SecondCustomFilter();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {

    // // NOTE httpBasic is deprecated because its sending credential in plaintext -
    // // should use JWT, OAuth or form-based authentication
    // http.authorizeHttpRequests(
    // auth ->
    // auth.requestMatchers("/backoffice/**").permitAll().anyRequest().authenticated())
    // .formLogin(formLogin -> formLogin.defaultSuccessUrl("/", true).permitAll())
    // .httpBasic();

    // // http.authorizeRequests(authorizeRequests ->
    // // authorizeRequests
    // // .antMatchers("/public/**").permitAll() // Allow access to /public/**
    // without
    // // authentication
    // // .anyRequest().authenticated() // All other endpoints require
    // authentication
    // // )
    // // .formLogin(formLogin ->
    // // formLogin
    // // .loginPage("/login")
    // // .permitAll()
    // // )
    // // .logout(logout ->
    // // logout
    // // .permitAll()
    // // );
    // // return http.build();

    // http.addFilterBefore(firstCustomFilter(),
    // UsernamePasswordAuthenticationFilter.class);
    // http.addFilterAfter(secondCustomFilter(), FirstCustomFilter.class);

    // return http.build();
    // }
}
