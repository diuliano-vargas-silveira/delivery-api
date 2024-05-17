package br.com.delivery.deliveryapi.mappers;

import br.com.delivery.deliveryapi.dto.UserRegisterRequest;
import br.com.delivery.deliveryapi.model.Order;
import br.com.delivery.deliveryapi.model.Users;

import java.util.ArrayList;
import java.util.UUID;

public class AuthenticationMapper {

    public static Users userRegisterRequestToUsers(UserRegisterRequest userRegisterRequest) {
        return Users.builder()
                .name(userRegisterRequest.name())
                .addresses(new ArrayList<>())
                .phoneNumber(userRegisterRequest.phoneNumber())
                .document(userRegisterRequest.document())
                .login(userRegisterRequest.login())
                .password(userRegisterRequest.password())
                .role(userRegisterRequest.role())
                .build();
    }
}
