package br.com.delivery.deliveryapi.authorization;

import br.com.delivery.deliveryapi.dto.AuthenticationReponse;
import br.com.delivery.deliveryapi.dto.AuthenticationRequest;
import br.com.delivery.deliveryapi.dto.UserRegisterRequest;
import br.com.delivery.deliveryapi.mappers.AuthenticationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authorization")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationReponse> register(@RequestBody UserRegisterRequest request) {
        var user = AuthenticationMapper.userRegisterRequestToUsers(request);

        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
