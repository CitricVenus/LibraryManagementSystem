package com.example.RestWithSQL;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(String message){
        super(message);
    }
}
