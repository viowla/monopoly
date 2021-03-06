package com.example.monopoly.exceptions;

import com.example.monopoly.services.exceptionService.EconomicService;

public class FreeRentException extends NoSuchMethodException {

    public FreeRentException(){
        super("User can't give free rent!");
    }

    public FreeRentException(String s){
        super(s);
    }
}
