package com.fourflyairline.backendairlinebookingsystem.security;

import com.fourflyairline.backendairlinebookingsystem.model.Authority;
import com.fourflyairline.backendairlinebookingsystem.security.filters.CollegeCourseAuthenticationFilter;
import com.fourflyairline.backendairlinebookingsystem.security.filters.CollegeCourseAuthorizationFilter;
import com.fourflyairline.backendairlinebookingsystem.security.services.JwtService;
import com.fourflyairline.backendairlinebookingsystem.security.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;



@Configuration
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityConfig {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CollegeCourseAuthorizationFilter authorizationFilter;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(c->c.disable())
                .sessionManagement(c->c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(httpSecurityCorsConfigurer -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedMethods(List.of("POST", "PUT", "GET"));
                    corsConfiguration.setAllowedOrigins(List.of("*"));
                })
                .addFilterAt(new CollegeCourseAuthenticationFilter(authenticationManager, jwtService), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authorizationFilter, CollegeCourseAuthenticationFilter.class)
                .authorizeHttpRequests(c->c.requestMatchers(getPublicEndpoints()).permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/user", "/api/v1/user/**").hasAnyAuthority(Authority.USER.name())
                        . requestMatchers(HttpMethod.POST,   "/api/v1/post/create").hasAnyAuthority(Authority.USER.name()))
                .build();
    }
    /**
     * get user by id ==> /api/v1/user/1
     * /api/v1/user != /api/v1/user/1
     * get all users ==> /api/v1/user?page=1&size=5 ==  /api/v1/user
     * */

    private static String[] getPublicEndpoints(){
        return SecurityUtils.getPublicEndpoints()
                .toArray(String[]::new);
    }
}
