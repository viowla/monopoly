package com.example.monopoly;

import org.springframework.stereotype.Component;


public class Square {
    String name;

    public Square(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void doAction(Player player, Board board){}
}
