package com.example.springbootuniversityprojects.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    public ResponseEntity<Object> handleJsonFormatException(Exception exception, WebRequest request){
        return handleExceptionInternal(exception, "Invalid Json format.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
