package br.com.delivery.deliveryapi.config;

import br.com.delivery.deliveryapi.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security
                .csrf((AbstractHttpConfigurer::disable))
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/api/authorization/**", "/", "/api-docs", "/api-docs/**",
                            "/swagger-resources/**", "/swagger-ui/**").permitAll();
                    authorize.requestMatchers("/products/most-sold").hasAuthority(Role.CUSTOMER.name());
                    authorize.requestMatchers("/restaurant/product").hasAuthority(Role.RESTAURANT.name());
                    authorize.anyRequest().authenticated();
                }).sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                }).authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return security.build();
    }
}
