package com.example.monopoly.models.squares;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Square {
    String name;

    public abstract void doAction(Player player, Board board);

}
