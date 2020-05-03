package com.example.monopoly.services.exceptionService;

import com.example.monopoly.exceptions.FreeRentException;
import org.springframework.stereotype.Service;

@Service
public class EconomicService {

    public int rent(int cost) throws FreeRentException{
        if (cost==0){
            throw new FreeRentException("You can't give free rent!");
        }
        return cost;
    }

    public int testException(){
        throw new NullPointerException("Exception");
    }
}
