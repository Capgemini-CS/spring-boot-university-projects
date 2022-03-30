package com.example.springbootuniversityprojects.validation;

import org.springframework.stereotype.Service;

@Service
public class NumberValidation implements NumberValidationInterface{

    @Override
    public boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The value is not numeric.");
        }
    }

}
