package br.com.delivery.deliveryapi.authorization;

import br.com.delivery.deliveryapi.dto.AuthenticationReponse;
import br.com.delivery.deliveryapi.dto.AuthenticationRequest;
import br.com.delivery.deliveryapi.enums.Role;
import br.com.delivery.deliveryapi.mappers.UserMapper;
import br.com.delivery.deliveryapi.model.Users;
import br.com.delivery.deliveryapi.repositories.DeliveryPersonRepository;
import br.com.delivery.deliveryapi.repositories.RestaurantRepository;
import br.com.delivery.deliveryapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final RestaurantRepository restaurantRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationReponse register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        createUserByRole(user);

        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationReponse(jwtToken);
    }

    public AuthenticationReponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.login(), authenticationRequest.password())
        );

        var user = repository.findByLogin(authenticationRequest.login())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationReponse(jwtToken);
    }

    private void createUserByRole(Users user) {
        switch (user.getRole()) {
            case CUSTOMER -> {
                repository.save(user);
            }
            case RESTAURANT -> {
                var restaurant = UserMapper.userToRestaurant(user);
                restaurantRepository.save(restaurant);
            }
            case DELIVERY_PERSON -> {
                var deliveryPerson = UserMapper.userToDeliveryPerson(user);
                deliveryPersonRepository.save(deliveryPerson);
            }
        }
    }

}
