package com.example.monopoly.models.squares;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;

public abstract class Square {
    String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void doAction(Player player, Board board);
}
