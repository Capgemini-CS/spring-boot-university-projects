package com.example.springbootuniversityprojects.exception;

public class JsonFormatException extends RuntimeException{

    public JsonFormatException(String errorMessage){
        super(errorMessage);
    }
}
