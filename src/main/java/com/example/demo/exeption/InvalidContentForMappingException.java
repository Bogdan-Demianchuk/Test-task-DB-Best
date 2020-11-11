package com.example.demo.exeption;

public class InvalidContentForMappingException extends RuntimeException {
    public InvalidContentForMappingException(String massage) {
        super(massage);
    }
}
