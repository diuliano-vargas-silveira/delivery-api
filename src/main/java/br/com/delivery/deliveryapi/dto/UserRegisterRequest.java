package br.com.delivery.deliveryapi.dto;

import br.com.delivery.deliveryapi.enums.Role;

public record UserRegisterRequest(String name, String login, String password, String phoneNumber, String document,
                                  Role role) {
}
