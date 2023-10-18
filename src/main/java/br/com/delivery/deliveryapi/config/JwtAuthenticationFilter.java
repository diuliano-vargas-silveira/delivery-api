package br.com.delivery.deliveryapi.config;

import br.com.delivery.deliveryapi.authorization.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN = "Bearer ";
    private static final int GET_HASH = 7;

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION_HEADER);
        final String jwt;
        final String login;

        if (authHeader == null || !authHeader.startsWith(BEARER_TOKEN)) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(GET_HASH);
        login = jwtService.extractLogin(jwt);

    }
}
