package br.com.delivery.deliveryapi.exceptions;

public class NoTokenPresentException extends Exception {
    public NoTokenPresentException(String errorMessage) {
        super(errorMessage);
    }
}
