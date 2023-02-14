package com.randebrock.worldsBestBank.security;

import com.randebrock.worldsBestBank.filters.CustomAuthenticationFilter;
import com.randebrock.worldsBestBank.filters.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    // UserDetailsService is an interface provided by Spring Security that defines a way to retrieve user information
    // Implementation is in CustomUserDetailsService
    @Autowired
    private UserDetailsService userDetailsService;

    // Autowired instance of the AuthenticationManagerBuilder
    @Autowired
    private AuthenticationManagerBuilder authManagerBuilder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authManagerBuilder.getOrBuild());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests()
                .anyRequest().permitAll(); // <-- Aquí estamos colocando TODAS nuestras rutas de manera pública
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean ------- example
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // CustomAuthenticationFilter instance created
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authManagerBuilder.getOrBuild());
//        // set the URL that the filter should process
//        customAuthenticationFilter.setFilterProcessesUrl("/login");
//        // disable CSRF protection
//        http.csrf().disable();
//        // set the session creation policy to stateless
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // set up authorization for different request matchers and user roles
//        http.authorizeHttpRequests() // GET /hello/user
//                .requestMatchers(HttpMethod.GET, "/hello-world").authenticated() // any role
//                .requestMatchers(HttpMethod.GET, "/hello/admin").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/hello/user").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.GET, "/curses/*/department").hasRole("ADMIN")
//                .anyRequest().permitAll(); // Any other route will be public
//
//        // add the custom authentication filter to the http security object
//        http.addFilter(customAuthenticationFilter);
//        // Add the custom authorization filter before the standard authentication filter.
//        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        // Build the security filter chain to be returned.
//        return http.build();
//    }


}