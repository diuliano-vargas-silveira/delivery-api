package br.com.delivery.deliveryapi.mappers;

import br.com.delivery.deliveryapi.dto.UserRegisterRequest;
import br.com.delivery.deliveryapi.model.Users;

import java.util.ArrayList;
import java.util.UUID;

public class AuthenticationMapper {

    public static Users userRegisterRequestToUsers(UserRegisterRequest userRegisterRequest) {
        return Users.builder()
                .id(1L) // FIXME: change this later to map a real id
                .name(userRegisterRequest.name())
                .addresses(new ArrayList<>())
                .orders(new ArrayList<>())
                .phoneNumber(userRegisterRequest.phoneNumber())
                .document(userRegisterRequest.document())
                .login(userRegisterRequest.login())
                .password(userRegisterRequest.password())
                .role(userRegisterRequest.role())
                .build();
    }
}
