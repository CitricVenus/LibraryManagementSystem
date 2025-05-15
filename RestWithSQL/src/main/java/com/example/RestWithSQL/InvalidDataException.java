package com.example.RestWithSQL;

public class InvalidDataException extends RuntimeException{
    InvalidDataException(String message){
        super(message);
    }
}
