package com.example.RestWithSQL;

public class BookDoesntExistException extends RuntimeException{
    public BookDoesntExistException(String message){
        super(message);
    }
}
