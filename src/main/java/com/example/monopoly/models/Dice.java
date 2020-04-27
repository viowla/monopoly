package com.example.monopoly.models;

import java.util.Random;

public class Dice {

    public int setDice(){
        int dice=(int) (Math.random()*6+1);
        return dice;
    }
}
