package com.example.demo.exeption;

public class InvalidGraphContentException extends RuntimeException{
    public InvalidGraphContentException(String massage){
        super(massage);
    }

}
