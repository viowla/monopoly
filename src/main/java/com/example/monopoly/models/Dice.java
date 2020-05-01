package com.example.monopoly.models;

import lombok.Setter;

import java.util.Random;

@Setter
public class Dice {
    int dice=(int) (Math.random()*6+1);
    /*
    public int setDice(){
        return dice;
    }*/
}
