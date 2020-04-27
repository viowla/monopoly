package com.example.monopoly.models;


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
