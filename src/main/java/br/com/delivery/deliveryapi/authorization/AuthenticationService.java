package br.com.delivery.deliveryapi.authorization;

import br.com.delivery.deliveryapi.dto.AuthenticationReponse;
import br.com.delivery.deliveryapi.dto.AuthenticationRequest;
import br.com.delivery.deliveryapi.dto.UserRegisterRequest;
import br.com.delivery.deliveryapi.model.Users;
import br.com.delivery.deliveryapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationReponse register(UserRegisterRequest userRegisterRequest) {
        var user = Users.builder()
                .id(UUID.randomUUID())
                .name(userRegisterRequest.name())
                .addresses(new ArrayList<>())
                .login(userRegisterRequest.login())
                .password(passwordEncoder.encode(userRegisterRequest.password()))
                .role(userRegisterRequest.role())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationReponse(jwtToken);
    }

    public AuthenticationReponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.login(), authenticationRequest.password() )
        );

        var user = repository.findByLogin(authenticationRequest.login()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationReponse(jwtToken);
    }

}
