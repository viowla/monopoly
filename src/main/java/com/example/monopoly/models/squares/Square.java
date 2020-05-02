package com.example.monopoly.models.squares;


import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square {

    String name;

    public Square(String name){
        this.name=name;
    }

    /*public String getName(){
        return name;
    }*/

    public void doAction(Player player, Board board){

    }
}
