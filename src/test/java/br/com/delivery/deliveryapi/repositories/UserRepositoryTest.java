package br.com.delivery.deliveryapi.repositories;

import br.com.delivery.deliveryapi.enums.Role;
import br.com.delivery.deliveryapi.model.Users;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldFindByLoginAnUserIfExistAnUserWithThatCredentials() {
        String email = "rosemariedas@email.com";

        Users user = Users.builder()
                .id(UUID.randomUUID())
                .orders(new ArrayList<>())
                .login(email)
                .phoneNumber("5196884812")
                .document("55673656084")
                .name("Rosemarie da Silva")
                .role(Role.CUSTOMER)
                .addresses(new ArrayList<>())
                .password("senhaForte")
                .build();

        userRepository.save(user);

        Optional<Users> userRepositoryByLogin = userRepository.findByLogin(email);

        var userLogin = userRepositoryByLogin.get();

        assertThat(userLogin.getLogin()).isEqualTo(user.getLogin());
    }
}