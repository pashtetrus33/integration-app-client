package com.example.spring_app_cleint.exception;

public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }
}
