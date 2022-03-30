package com.example.springbootuniversityprojects.service.util;

import org.springframework.stereotype.Service;

@Service
public class UtilConvertor implements UtilConvertorInterface{

    @Override
    public int stringToInt(String stringToConvert){
        return Integer.parseInt(stringToConvert);
    }
}
