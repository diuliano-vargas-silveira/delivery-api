package br.com.delivery.deliveryapi.controllers;

import br.com.delivery.deliveryapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final UserRepository userRepository;

    @GetMapping
    public String exampleEndpoint() {
        return "It's working guys!";
    }
}
