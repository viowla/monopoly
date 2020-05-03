package com.example.monopoly.exceptions;

import com.example.monopoly.services.EconomicService;

public class FreeRentException extends EconomicService {
    public FreeRentException(){
        super("User can't give free rent!");
    }

    public FreeRentException(String s){
        super(s);
    }
}
