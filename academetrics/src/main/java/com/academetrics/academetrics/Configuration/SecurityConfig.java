package com.academetrics.academetrics.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {return new UserInfoUserDetailsService();}

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081")); // Replace with the actual origin of your frontend application
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        configuration.setAllowCredentials(true); // Allow including credentials in requests

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/welcome").authenticated()
                .and()
                .formLogin()
                .successHandler(mp_successHandler())
                .failureHandler(mp_failureHandler())
                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/login/Success",true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Specify the logout URL
                .logoutSuccessHandler(logoutSuccessHandler())  // Return HTTP status without redirection
                .invalidateHttpSession(true) // Invalidate the HttpSession
                .deleteCookies("jsessionid") // Delete the session cookie
                .permitAll() // Allow access to the logout URL without authentication
                .and()
                .authorizeHttpRequests().requestMatchers("/**").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedEntryPoint())
                .and()
                .build();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        };
    }
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(null);
            request.getSession().invalidate();
            // Custom logout logic here
            response.setStatus(HttpServletResponse.SC_OK);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    private AuthenticationSuccessHandler mp_successHandler() {
        return (request, response, authentication) -> {
            // Custom success logic here

            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
        };
    }

    private AuthenticationFailureHandler mp_failureHandler() {
        return (request, response, exception) -> {
            // Custom failure logic here
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Invalid credentials");
        };
    }




}