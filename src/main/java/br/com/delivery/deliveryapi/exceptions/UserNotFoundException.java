package br.com.delivery.deliveryapi.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Usuário não existe!");
    }
}
