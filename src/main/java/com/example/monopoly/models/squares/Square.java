package com.example.monopoly.models.squares;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;
import lombok.Getter;

@Getter
public abstract class Square {
    String name;

    public Square(String name) {
        this.name = name;
    }

    public abstract void doAction(Player player, Board board);
}
