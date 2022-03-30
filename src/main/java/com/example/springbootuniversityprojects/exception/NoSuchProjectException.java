package com.example.springbootuniversityprojects.exception;

public class NoSuchProjectException extends RuntimeException {

    public NoSuchProjectException(String errorMessage){
        super(errorMessage);
    }


}
