package com.example.springbootuniversityprojects.exception;

public class JsonFormatException extends Exception{

    public JsonFormatException(String errorMessage){
        super(errorMessage);
    }
}
